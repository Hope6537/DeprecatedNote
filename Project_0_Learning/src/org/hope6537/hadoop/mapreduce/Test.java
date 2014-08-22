package org.hope6537.hadoop.mapreduce;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/** 
 * <p>Describe: Hadoop program example </p>
 * <p>Using: For Test </p>
 * <p>DevelopedTime: 2014年8月21日下午7:37:12</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see org.apache.hadoop.conf.Configured;org.apache.hadoop.util.Tool;
 */
public class Test extends Configured implements Tool {

	enum Counter {
		LINESKIP;// 错误计数器
	}

	public static class Map extends
			Mapper<LongWritable, Text, NullWritable, Text> {

		@Override
		protected void map(LongWritable key, Text value,
				Mapper<LongWritable, Text, NullWritable, Text>.Context context)
				throws IOException, InterruptedException {

			String line = value.toString(); // 读取源数据
			try {

				String[] values = line.split(" ");// 对源数据进行分割和重组
				String month = values[0];
				String day = values[1];
				String mac = values[6];
				Text result = new Text(month + "-" + day + " : " + mac);
				context.write(NullWritable.get(), result);

			} catch (Exception e) {
				context.getCounter(Counter.LINESKIP).increment(1);// 出错使计数器加一
				return;
			}

		}
	}

	@Override
	public int run(String[] arg0) throws Exception {
		Configuration configuration = getConf();
		Job job = new Job(configuration, "Test"); // 任务名称
		job.setJarByClass(Test.class);// 指定驱动class
		FileInputFormat.addInputPath(job, new Path(arg0[0])); // 注意这两个类引包的时候的跟比之处
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		job.setMapperClass(Map.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		job.waitForCompletion(true);

		System.out.println("任務名稱 " + job.getJobName());
		System.out.println("任務成功 " + job.isSuccessful());
		System.out.println("輸入行數 "
				+ job.getCounters().findCounter(
						"org.apache.hadoop.mapred.Task",
						"org.apache.hadoop.io.Text"));
		System.out.println("輸出行數 "
				+ job.getCounters().findCounter(
						"org.apache.hadoop.mapred.Task",
						"org.apache.hadoop.io.Text"));
		System.out.println("跳過的行數 "
				+ job.getCounters().findCounter(Counter.LINESKIP));

		return job.isSuccessful() ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new Test(), args);
		System.out.println(res);
		System.exit(res);
	}
}

