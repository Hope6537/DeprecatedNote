package org.hope6537.hadoop.mapreduce;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/** 
 * <p>Describe: Cauleate the students'avg score</p>
 * <p>Using: MapReduce</p>
 * <p>DevelopedTime: Aug 26, 20141:49:55 PM</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class StudentCount extends Configured implements Tool {

	public static class Map extends
			Mapper<LongWritable, Text, Text, DoubleWritable> {
		@Override
		protected void map(LongWritable key, Text value,
				Mapper<LongWritable, Text, Text, DoubleWritable>.Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			System.out.println("Command : " + line);
			StringTokenizer tokenizer = new StringTokenizer(line, "\n");
			while (tokenizer.hasMoreTokens()) {
				StringTokenizer tokenizerLine = new StringTokenizer(
						tokenizer.nextToken());
				String strname = tokenizerLine.nextToken();
				String strscore = tokenizerLine.nextToken();
				Text name = new Text(strname);
				DoubleWritable doubleWritable = new DoubleWritable(
						Double.parseDouble(strscore));
				context.write(name, doubleWritable);

			}
		}
	}

	public static class Reduce extends
			Reducer<Text, DoubleWritable, Text, DoubleWritable> {
		@Override
		protected void reduce(
				Text text,
				Iterable<DoubleWritable> values,
				Reducer<Text, DoubleWritable, Text, DoubleWritable>.Context context)
				throws IOException, InterruptedException {
			double sum = 0;
			int count = 0;
			Iterator<DoubleWritable> iterator = values.iterator();
			while (iterator.hasNext()) {
				sum += iterator.next().get();
				count++;
			}
			double avg = sum / count;
			context.write(text, new DoubleWritable(avg));
		}
	}

	@Override
	public int run(String[] args) throws Exception {
		Job job = new Job(getConf());
		job.setJarByClass(StudentCount.class);
		job.setJobName("StudentCounts");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setCombinerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int ret = ToolRunner.run(new StudentCount(), args);
		System.exit(ret);
	}
}
