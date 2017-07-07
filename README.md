# roundforest
Before running please set url of database in spring-config.xml

# Answers:
1) To make sure that there are no duplicates of strings in the file application stores hashcodes and compares new strings with already processed ones. In class Dictionary we use it on 23 line. We check if collection contains link of word(Node of last char of word)than we not add word in collection. 
2) Should run app with -Xmx500m key to restrict heap memory.For monitoring  memory usage can be used Jconsole, Jstat or JVisualVM tool.
3) To support the files with up to 100M reviews on multiple machines with 500MB of RAM and 4 core CPUs should use Spark or Hadoop.

