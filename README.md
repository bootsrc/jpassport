#flylib-passport
主要开发人员Frank Liu <br/>
Passport for Java WEB project via userId and token

- 技术架构： <br/>
1.Spring + Spring MVC + myBatis <br/>
2.maven <br/>
3.flylib-passport登录模块 <br/>
4.mysql <br/>
5.redis <br/>
<br/>
- 使用说明
如何使用flylib-passport库，参考项目https://github.com/flylib/flylib-site  <br/>
Please check demo at https://github.com/flylib/flylib-site <br/>

Usage: <br/>
Step1: git clone https://github.com/flylib/flylib-passport.git   <br/>
Step2: cd flylib-passport   <br/>
   mvn install    <br/>
Then flylib-passport.jar is installed in your local maven repo.  <br/>
Step3: Reference flylib-passport-1.0.0-SNAPSHOT.jar in your own SpringMVC project. Please clone flylib-site to see this example
git clone https://github.com/flylib/flylib-site.git    and run it. <br/>
<br/>

<pre><code>
	<dependency>
		<groupId>org.flylib</groupId>
		<artifactId>flylib-passport</artifactId>
		<version>1.0.0-SNAPSHOT</version>
	</dependency>
</pre></code>
<br/>
