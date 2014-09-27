package org.hope6537.hadoop.mapreduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/** 
 * <p>Describe: 单表关联 </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年9月1日下午12:36:23</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class STJoin {

	public static int time = 0;

	public static class Map extends Mapper<Object, Text, Text, Text> {

		@Override
		protected void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {

			String childname = new String();
			String parentname = new String();
			String relationtype = new String();
			String line = value.toString();
			int i = 0;
			while (line.charAt(i) != ' ') {
				i++;
			}
			String[] values = { line.substring(0, i), line.substring(i + 1) };
			if (values[0].compareTo("child") != 0) {
				childname = values[0];
				parentname = values[1];
				relationtype = "1";// 左右表区分标志
				context.write(new Text(values[1]), new Text(relationtype + "+"
						+ childname + "+" + parentname));
				// 左表
				relationtype = "2";
				context.write(new Text(values[0]), new Text(relationtype + "+"
						+ childname + "+" + parentname));
				// 右表

			}

		}
	}

	public static class Reduce extends Reducer<Text, Text, Text, Text> {

		protected void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {
			if (time == 0) {
				context.write(new Text("grandChild"), new Text("grandParent"));
				time++;
			}
			int grandchildnum = 0;
			String[] grandchild = new String[10];
			int grandparentnum = 0;
			String[] grandparent = new String[10];
			Iterator<Text> ite = values.iterator();
			while (ite.hasNext()) {
				String record = ite.next().toString();
				int len = record.length();
				int i = 2;
				if (len == 0) {
					continue;
				}
				char relationtype = record.charAt(0);
				String childname = new String();
				String parentname = new String();
				while (record.charAt(i) != '+') {
					childname += record.charAt(i);
					i++;
				}
				i++;
				while (i < len) {
					parentname += record.charAt(i);
					i++;
				}
				if (relationtype == '1') {
					grandchild[grandchildnum] = childname;
					grandchildnum++;
				} else {
					grandparent[grandparentnum] = parentname;
					grandparentnum++;
				}
				if (grandparentnum != 0 && grandchildnum != 0) {
					for (int m = 0; m < grandchildnum; m++) {
						for (int n = 0; n < grandparentnum; n++) {
							context.write(new Text(grandchild[m]), new Text(
									grandparent[n]));

						}
					}
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length < 2) {
			System.exit(2);
		}
		Job job = new Job(conf, "Single Table Join");
		job.setJarByClass(STJoin.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		// job.setPartitionerClass(Partition.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0])); // 注意这两个类引包的时候的跟比之处
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
