# 工程代码调整
## 修改项目版本号
```
mvn versions:set -DnewVersion=2.3.5-hd-SNAPSHOT
```
## 根pom.xml文件修改
注释以下模块
```
<module>seatunnel-translation</module>
```

## 保留seatunnel-e2e中必要的模块

```
 <module>seatunnel-e2e-common</module>
```

## 注释 seatunnel-examples中多余的子模块
```
<module>seatunnel-flink-connector-v2-example</module>
<module>seatunnel-spark-connector-v2-example</module>
```
##  注释seatunnel-core中多余的子模块
```
<module>seatunnel-flink-starter</module>
<module>seatunnel-spark-starter</module>
```
## 保留 seatunnel-connectors-v2中使用的子模块
```
 <module>connector-common</module>
 <module>connector-cdc</module>
 <module>connector-console</module>
 <module>connector-fake</module>
 <module>connector-http</module>
 <module>connector-jdbc</module>
 <module>connector-file</module>
 <module>connector-elasticsearch</module>
 <module>connector-doris</module>
 <module>connector-selectdb-cloud</module>
```
##  seatunnel-dist模块调整
### 除去不需要的jdbc驱动和connector
```
<?xml version="1.0" encoding="UTF-8"?>
 
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.apache.seatunnel</groupId>
        <artifactId>seatunnel</artifactId>
        <version>${revision}</version>
    </parent>

    <artifactId>seatunnel-dist</artifactId>
    <name>SeaTunnel : Dist</name>

    <properties>
        <!-- disable mvn deploy to central maven repo by default -->
        <maven.deploy.skip>true</maven.deploy.skip>
    </properties>

    <build>
        <finalName>apache-seatunnel-${project.version}</finalName>
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <executions>
                    <execution>
                        <id>bin</id>
                        <goals>
                            <goal>single</goal>
                        </goals>
                        <phase>package</phase>
                        <configuration>
                            <descriptors>
                                <descriptor>src/main/assembly/assembly-bin-ci.xml</descriptor>
                            </descriptors>
                            <appendAssemblyId>true</appendAssemblyId>
                        </configuration>
                    </execution>

                </executions>
            </plugin>
        </plugins>
    </build>

    <profiles>
        <profile>
            <id>seatunnel</id>
            <activation>
                <activeByDefault>true</activeByDefault>
                <property>
                    <name>release</name>
                    <value>false</value>
                </property>
            </activation>
            <properties>
                <mysql.version>8.0.27</mysql.version>
                <postgresql.version>42.4.3</postgresql.version>
                <postgis.jdbc.version>2.5.1</postgis.jdbc.version>
                <dm-jdbc.version>8.1.2.141</dm-jdbc.version>
                <sqlserver.version>9.2.1.jre8</sqlserver.version>
                <phoenix.version>5.2.5-HBase-2.x</phoenix.version>
                <oracle.version>12.2.0.1</oracle.version>
                <sqlite.version>3.39.3.0</sqlite.version>
                <db2.version>db2jcc4</db2.version>
                <sqlite.version>3.39.3.0</sqlite.version>
                <tablestore.version>5.13.9</tablestore.version>
                <teradata.version>17.20.00.12</teradata.version>
                <redshift.version>2.1.0.9</redshift.version>
                <snowflake.version>3.13.29</snowflake.version>

                <!-- Imap storage dependency package  -->
                <hadoop-aliyun.version>3.0.0</hadoop-aliyun.version>
                <json-smart.version>2.4.7</json-smart.version>
                <hadoop-aws.version>3.1.4</hadoop-aws.version>
                <aws-java-sdk.version>1.11.271</aws-java-sdk.version>
                <netty-buffer.version>4.1.89.Final</netty-buffer.version>
                <hive.exec.version>2.3.9</hive.exec.version>
                <hive.jdbc.version>3.1.3</hive.jdbc.version>
                <aliyun.sdk.oss.version>3.4.1</aliyun.sdk.oss.version>
                <jdom.version>1.1</jdom.version>
            </properties>
            <dependencies>
                <!-- starters -->

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-starter</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <!-- transforms -->
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-transforms-v2</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <!-- connectors -->
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-fake</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-console</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-assert</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-jdbc</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-elasticsearch</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-doris</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-selectdb-cloud</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-file-local</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-file-oss</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <!-- jdbc driver -->

                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>${mysql.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>com.dameng</groupId>
                    <artifactId>DmJdbcDriver18</artifactId>
                    <version>${dm-jdbc.version}</version>
                    <scope>provided</scope>
                </dependency>

                <!-- jdbc driver end -->

                <dependency>
                    <groupId>io.netty</groupId>
                    <artifactId>netty-buffer</artifactId>
                    <version>${netty-buffer.version}</version>
                    <scope>provided</scope>
                </dependency>

                <!-- hadoop jar -->
                <dependency>
                    <groupId>org.apache.hadoop</groupId>
                    <artifactId>hadoop-aws</artifactId>
                    <version>${hadoop-aws.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-hadoop3-3.1.4-uber</artifactId>
                    <version>${project.version}</version>
                    <classifier>optional</classifier>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>com.aliyun.oss</groupId>
                    <artifactId>aliyun-sdk-oss</artifactId>
                    <version>${aliyun.sdk.oss.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.jdom</groupId>
                    <artifactId>jdom</artifactId>
                    <version>${jdom.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.hadoop</groupId>
                    <artifactId>hadoop-aliyun</artifactId>
                    <version>${hadoop-aliyun.version}</version>
                    <scope>provided</scope>
                </dependency>
                <!-- hadoop jar end -->
            </dependencies>

        </profile>
        <profile>
            <id>release</id>
            <activation>
                <property>
                    <name>release</name>
                    <value>true</value>
                </property>
            </activation>
            <dependencies>
                <!-- starters -->
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-starter</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-flink-13-starter</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-flink-15-starter</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-spark-2-starter</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-spark-3-starter</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>com.amazonaws</groupId>
                    <artifactId>aws-java-sdk-bundle</artifactId>
                    <version>1.11.271</version>
                    <scope>provided</scope>
                </dependency>
                <!-- seatunnel connectors for demo -->
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-fake</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>connector-console</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <!-- transforms v2 -->
                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-transforms-v2</artifactId>
                    <version>${project.version}</version>
                    <scope>provided</scope>
                </dependency>

                <dependency>
                    <groupId>org.apache.seatunnel</groupId>
                    <artifactId>seatunnel-hadoop3-3.1.4-uber</artifactId>
                    <version>${project.version}</version>
                    <classifier>optional</classifier>
                    <scope>provided</scope>
                </dependency>
            </dependencies>
            <build>
                <finalName>apache-seatunnel-${project.version}</finalName>
                <plugins>
                    <plugin>
                        <artifactId>maven-assembly-plugin</artifactId>
                        <executions>
                            <execution>
                                <id>bin</id>
                                <goals>
                                    <goal>single</goal>
                                </goals>
                                <phase>package</phase>
                                <configuration>
                                    <descriptors>
                                        <descriptor>src/main/assembly/assembly-bin.xml</descriptor>
                                    </descriptors>
                                    <appendAssemblyId>true</appendAssemblyId>
                                </configuration>
                            </execution>

                            <execution>
                                <id>src</id>
                                <goals>
                                    <goal>single</goal>
                                </goals>
                                <phase>package</phase>
                                <configuration>
                                    <descriptors>
                                        <descriptor>src/main/assembly/assembly-src.xml</descriptor>
                                    </descriptors>
                                    <appendAssemblyId>true</appendAssemblyId>
                                </configuration>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>
</project>

```

### 调整assembly-bin-ci.xml文件，去除不需要的flink,spark的启动类和jdbc驱动
```
<!--

    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

-->
<assembly xmlns="http://maven.apache.org/ASSEMBLY/2.1.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/ASSEMBLY/2.1.0 http://maven.apache.org/xsd/assembly-2.1.0.xsd">
    <id>bin</id>
    <formats>
        <format>tar.gz</format>
    </formats>
    <includeBaseDirectory>true</includeBaseDirectory>
    <fileSets>
        <fileSet>
            <directory>../</directory>

            <excludes>
                <exclude>**/target/**</exclude>
                <exclude>**/.classpath</exclude>
                <exclude>**/.project</exclude>
                <exclude>**/.settings/**</exclude>
                <exclude>lib/**</exclude>
            </excludes>

            <includes>
                <include>README.md</include>
                <include>config/**</include>
                <include>plugins/**</include>
            </includes>
        </fileSet>
        <!-- ============ Install Plugin Bin ============  -->
        <fileSet>
            <directory>../bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>
        <!-- ============ Starter Bin ============  -->
        <fileSet>
            <directory>../seatunnel-core/seatunnel-flink-starter/seatunnel-flink-13-starter/src/main/bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>
        <fileSet>
            <directory>../seatunnel-core/seatunnel-flink-starter/seatunnel-flink-15-starter/src/main/bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>
        <fileSet>
            <directory>../seatunnel-core/seatunnel-spark-starter/seatunnel-spark-2-starter/src/main/bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>
        <fileSet>
            <directory>../seatunnel-core/seatunnel-spark-starter/seatunnel-spark-3-starter/src/main/bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>
        <fileSet>
            <directory>../seatunnel-core/seatunnel-starter/src/main/bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>

        <fileSet>
            <directory>${project.build.directory}/bin</directory>
            <outputDirectory>/bin</outputDirectory>
            <includes>
                <include>*</include>
            </includes>
            <fileMode>0755</fileMode>
        </fileSet>
        <!--Licenses And NOTICE-->
        <fileSet>
            <directory>release-docs</directory>
            <outputDirectory>.</outputDirectory>
        </fileSet>
        <!-- DISCLAIMER -->
        <fileSet>
            <directory>${basedir}/.././</directory>
            <includes>
                <include>DISCLAIMER</include>
            </includes>
            <outputDirectory>.</outputDirectory>
        </fileSet>
    </fileSets>

    <files>
        <file>
            <source>../plugin-mapping.properties</source>
            <outputDirectory>/connectors</outputDirectory>
        </file>
    </files>
    <dependencySets>
        <!-- ============ Logging Jars ============  -->
        <dependencySet>
            <useProjectArtifact>false</useProjectArtifact>
            <useTransitiveDependencies>true</useTransitiveDependencies>
            <unpack>false</unpack>
            <outputDirectory>/starter/logging</outputDirectory>
            <includes>
                <include>org.slf4j:slf4j-api:jar</include>
                <include>org.slf4j:jcl-over-slf4j:jar</include>
                <include>org.apache.logging.log4j:log4j-api:jar</include>
                <include>org.apache.logging.log4j:log4j-core:jar</include>
                <include>org.apache.logging.log4j:log4j-slf4j-impl:jar</include>
            </includes>
        </dependencySet>

        <!-- ============ Starter Jars ============  -->
        <dependencySet>
            <useProjectArtifact>false</useProjectArtifact>
            <useTransitiveDependencies>true</useTransitiveDependencies>
            <unpack>false</unpack>
            <includes>
                <!-- Flink V2 starter -->

                <!-- SeaTunnel Engine starter -->
                <include>org.apache.seatunnel:seatunnel-starter:jar</include>
            </includes>
            <outputFileNameMapping>${artifact.file.name}</outputFileNameMapping>
            <outputDirectory>/starter</outputDirectory>
            <scope>provided</scope>
        </dependencySet>

        <!-- ============ Connectors Jars ============  -->
        <!-- SeaTunnel connectors -->
        <dependencySet>
            <useProjectArtifact>false</useProjectArtifact>
            <useTransitiveDependencies>true</useTransitiveDependencies>
            <unpack>false</unpack>
            <includes>
                <include>org.apache.seatunnel:connector-*:jar</include>
            </includes>
            <excludes>
                <exclude>org.apache.seatunnel:connector-common</exclude>
                <!-- Don't exclude connector-http-base, because it contains SPI files -->
                <exclude>org.apache.seatunnel:connector-file-base</exclude>
                <exclude>org.apache.seatunnel:connector-file-base-hadoop</exclude>
                <exclude>org.apache.seatunnel:connector-cdc-base</exclude>
            </excludes>
            <outputDirectory>/connectors</outputDirectory>
            <scope>provided</scope>
        </dependencySet>

        <!-- ============ SeaTunnel Transforms V2 Jars And SeaTunnel Hadoop3 Uber Jar ============  -->
        <dependencySet>
            <useProjectArtifact>false</useProjectArtifact>
            <useTransitiveDependencies>true</useTransitiveDependencies>
            <unpack>false</unpack>
            <includes>
                <include>org.apache.seatunnel:seatunnel-transforms-v2:jar</include>
                <include>org.apache.hadoop:hadoop-aws:jar</include>
                <include>com.amazonaws:aws-java-sdk-bundle:jar</include>
                <include>org.apache.seatunnel:seatunnel-hadoop3-3.1.4-uber:jar:*:optional</include>
                <!--Add hadoop aliyun jar -->
                <include>org.apache.hadoop:hadoop-aliyun:jar</include>
                <include>com.aliyun.oss:aliyun-sdk-oss:jar</include>
                <include>org.jdom:jdom:jar</include>

                <!--Add netty buffer jar -->
                <include>io.netty:netty-buffer:jar</include>
                <include>io.netty:netty-common:jar</include>

            </includes>
            <outputFileNameMapping>${artifact.file.name}</outputFileNameMapping>
            <outputDirectory>/lib</outputDirectory>
            <scope>provided</scope>
        </dependencySet>

        <!-- =================== JDBC Connector Drivers ===================  -->
        <dependencySet>
            <useProjectArtifact>false</useProjectArtifact>
            <useTransitiveDependencies>true</useTransitiveDependencies>
            <unpack>false</unpack>
            <includes>
                <include>mysql:mysql-connector-java:jar</include>
                <include>com.dameng:DmJdbcDriver18:jar</include>
            </includes>
            <outputFileNameMapping>${artifact.file.name}</outputFileNameMapping>
            <outputDirectory>/lib</outputDirectory>
            <scope>provided</scope>
        </dependencySet>
    </dependencySets>
</assembly>

```

## 编译命令

```
格式化样式
mvn spotless:apply
编译打包
-T 4 clean package -Dmaven.test.skip=true
```