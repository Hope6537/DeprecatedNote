package org.hope6537.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.hope6537.hadoop.mapreduce.Debup.Map.Reduce;

/** 
 * <p>Describe: 去重复的MapReduce程序 </p>
 * <p>Using: </p>
 * <p>DevelopedTime: Aug 27, 20148:21:40 PM</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Debup {

	public static class Map extends Mapper<Object, Text, Text, Text> {

		private static Text line = new Text();

		@Override
		protected void map(Object key, Text value,
				Mapper<Object, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			line = value; // 直接将日志记录作为key来进行存储

			context.write(value, new Text(" "));
		}

		public static class Reduce extends Reducer<Text, Text, Text, Text> {
			@Override
			protected void reduce(Text arg0, Iterable<Text> arg1,
					Reducer<Text, Text, Text, Text>.Context arg2)
					throws IOException, InterruptedException {
				arg2.write(arg0, new Text(" "));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("Usage: in and out");
			System.exit(2);
		}
		Job job = new Job(conf, "Data Dedullication");
		job.setJarByClass(Debup.class);
		job.setMapperClass(Map.class);
		job.setCombinerClass(Reduce.class);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0])); // 注意这两个类引包的时候的跟比之处
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}
