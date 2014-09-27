package org.hope6537.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/** 
 * <p>Describe: MapReduce的大数据排序</p>
 * <p>Using: 用于数据分析挖掘</p>
 * <p>DevelopedTime: 2014年8月29日下午12:10:06</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Sort {

	/** 
	 * <p>Describe: Map过程的实现类</p>
	 * <p>Using: 用于梳理整数集，Map将会将value转化为IntWritable类型，作为输出的key</p>
	 * <p>DevelopedTime: 2014年8月29日下午12:10:32</p>
	 * <p>Company: ChangChun Unviersity JiChuang Team</p>
	 * @author Hope6537
	 * @version 1.0
	 * @see
	 */
	public static class Map extends
			Mapper<Object, Text, IntWritable, IntWritable> {
		private static IntWritable data = new IntWritable();

		@Override
		protected void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			data.set(Integer.parseInt(line));
			context.write(data, new IntWritable(1));
		}
	}

	/** 
	 * <p>Describe: Reduce过程的类</p>
	 * <p>Using: 将会吧输入的key复制到输出的value上，然后根据输入的value-list中元素的个数决定key的输出位数</p>
	 * <p>DevelopedTime: 2014年8月29日下午12:11:30</p>
	 * <p>Company: ChangChun Unviersity JiChuang Team</p>
	 * @author Hope6537
	 * @version 1.0
	 * @see
	 */
	public static class Reduce extends
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
		/**
		 * <p>Describe: 全局的计列器</p>
		 * <p>Using: 将会用全局的linenum来决定key的输出位数</p>
		 */
		private static IntWritable linenum = new IntWritable(1);

		protected void reduce(IntWritable key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			for (@SuppressWarnings("unused")
			IntWritable val : values) {
				context.write(linenum, key);
			}
			linenum = new IntWritable(linenum.get() + 1);
		}
	}

	/** 
	 * <p>Describe: 自定义的Partition</p>
	 * <p>Using: 此函数将会根据输入数据的最大值和MapReduce框架中Partition数量获取将输入数据按照大小分块的边界
	 * 然后根据输入的数值和边界的关系返回对应的PartitionID</p>
	 * <p>DevelopedTime: 2014年8月29日下午12:15:07</p>
	 * <p>Company: ChangChun Unviersity JiChuang Team</p>
	 * @author Hope6537
	 * @version 1.0
	 * @see
	 */
	public static class Partition extends Partitioner<IntWritable, IntWritable> {

		@Override
		public int getPartition(IntWritable key, IntWritable value,
				int numPartiions) {
			int maxNumber = 65223;
			int bound = maxNumber / numPartiions + 1;
			int keyNumber = key.get();
			for (int i = 0; i < numPartiions; i++) {
				if (keyNumber < bound * (i + 1) && keyNumber >= bound * i) {
					return i;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length < 2) {
			System.exit(2);
		}
		Job job = new Job(conf, "Sort");
		job.setJarByClass(Sort.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setPartitionerClass(Partition.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0])); // 注意这两个类引包的时候的跟比之处
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
