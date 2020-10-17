# Learning Big Data Computing with Spark
Homework 2 for CS 6220 Big Data Systems &amp; Analytics

![alt text](images/spark_logo.png)

### Problem 3. Learning Big Data Computing with Hadoop and/or Spark MapReduce

For this homework, I chose to complete Option 2 of Problem 3.

#### Requirements:
Installed software required to run the programs in this repository:
- Java 14.0.2
- JDK 14.0.2
- Hadoop 3.3.0
- Scala 2.13.3
- Spark 3.0.1
- Git 2.28.0 (optional)

#### My system description:
Specifications of the machine I used to run the programs in this repository:
- macOS Catalina (10.15.6)
- 2 GHz Quad-Core Intel Core i5 (10th Generation)
- 16 GB RAM
- 500 GB SSD
- Hadoop running on Pseudo-Distributed mode
- Apache Spark 3

#### Repository Folder Structure:
- **input:** 
    - All text inputs used for the MapReduce jobs.
- **WordCount:** 
    - Java MapReduce program to count the occurance of each word in a document or body of documents.
- **Top100Words:** 
    - Java MapReduce program to find the top 100 most common words across a body of documents.
- **output:** 
    - All outputs from the MapReduce jobs.
- **import_books:** 
    - Contains the jupyter notebook used to import books from the Gutenbert Project.
- **images:** 
    - Contains all images used in the Readme file.

### 1. HDFS Installation:

The first step of this homework was to setup HDFS in my local machine. In order to do so, I installed Java and Hadoop and edited the necessary configuration files.

- **Hadoop version:** 3.3.0
- **Hadoop mode:** Pseudo-Distributed (<value>1</value> on the hdfs-site.xml configuration file)
- **hadoop command** is available globally (hadoop binary files were added to the path)


- **Configuration File Edits:**
  - **hadoop-env.sh**:
    Make sure to set export **JAVA_HOME** to the the Java home location in your machine.
  - **core-site.xml**:

```xml
    <configuration>
      <property>
        <name>hadoop.tmp.dir</name>
        <value>/usr/local/Cellar/hadoop/hdfs/tmp</value>
        <description>A base for other temporary directories</description>             
      </property>
      <property>
        <name>fs.default.name</name>
        <value>hdfs://localhost:8020</value>
      </property>
    </configuration>
```
-
  - **mapred-site.xml**:

```xml
    <configuration>
      <property>
        <name>mapred.job.tracker</name>
        <value>localhost:8021</value>
      </property>
    </configuration>
```
-
  - **hdfs-site.xml**:

```xml
    <configuration>
      <property>
        <name>dfs.replication</name>
        <value>1</value>
      </property>
    </configuration>
```


Since my computer was running macOS I found the following installation tutorial very helpful: https://medium.com/beeranddiapers/installing-hadoop-on-mac-a9a3649dbc4d

If you are running Windows you can follow this tutorial: https://towardsdatascience.com/installing-hadoop-3-2-1-single-node-cluster-on-windows-10-ac258dd48aef

If you running Linux, you can follow the offical Apache Hadoop documentation: https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html

 ***After installing HDFS, start all services by running the start-all.sh script on the sbin folder inside the hadoop folder.***

- **Resource Manager Screenshot:**

![alt text](images/Resource%20Manager.png)

- **JobTracker Screenshot:**

![alt text](images/JobTracker.png)

- **Node Manager Screenshot:**

![alt text](images/Node%20Manager.png)

### 2. Apache Spark Installation:

Since my computer was running macOS, I followed these steps to install Apache Spark on my local machine (using Homebrew):

Install xcode-select:
```shell
    xcode-select --install
```
Install Scala:
```shell
    brew install scala
```
Install Apache Spark:
```shell
    brew install apache-spark
```

If you running Window or Linux, you can follow the offical Apache Spark documentation: https://spark.apache.org/docs/latest/

To check if Spark was properly installed, try opening the Spark CLI by running the following command:

```shell
    spark-shell
```

- You should see a similar result in your terminal window:

![alt text](images/spark-shell.png)

### 3. Data:

A number of different text files were used was input data for this homework. They are all saved in the input folder.

- american_pie.txt: 
  - lyrics to the song American Pie by Don McLean, obtained from https://www.letras.com/don-mclean/25411/
- hamlet.txt: 
  - William Shakespeare's famous tragedy Hamlet, obtained from https://gist.github.com/provpup/2fc41686eab7400b796b
- charles_dikens: 
  - this folder contains the 20 books published by the famous English author Charles Dickens.
  - These files were obtained from *Project Gutenberg* using the Gutenberg python library to fetch the data.
  - You can run the Jupyter notebook /import_books/import_charles_dickens_books.ipynb to understand the process.
- bbc_tech_news:
  - This folder contains 401 news articles by BBC on the topic of Technology.
  - The data was obtained from http://mlg.ucd.ie/datasets/bbc.html
- song_lyrics:
  - This data set contains the lyrics of songs by a number of different aritsts. For each artist, all of his or her lyrics were saved as a single txt file.
  - The data was obtained from https://www.kaggle.com/paultimothymooney/poetry
  - I manually subdivided the artists into four main genres:
    - Pop: 11 aritsts
    - Rock: 13 aritsts
    - Folk/Country: 6 aritsts
    - Hip-Hop: 11 aritsts
    
- Saving the data on HDFS:
  - To save the input data on HDFS, you just need to run the export_inputs.sh shell script in the root directory of the project by running the following command:
```shell
    sh export_inputs.sh
```
In my machine, the script took ~25 seconds to run.
