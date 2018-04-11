# Jeddy
A java Library to convert Objects to JSON or XML 

## Usage : JSON Object

**Example 1** : Simple Json Object output

```
JeddyObject user1 = new JeddyObject("user1");
user1.addNode("name", "John");
user1.addNode("age", "31");
user1.addNode("city", "Buea");

user1.toJson()
Output: {"name":"John","age":"31","city":"Buea"}

```

**Example 2** : An array Json output

```
JeddyObject names = new JeddyObject();
names.addNode("names", "john");
names.addNode("names", "Edward");
names.addNode("names", "Jude");

names.toJson()
Output: {"names":["john","Edward","Jude"]}

```

**Example 3** : An Array of Json Object output

```
JeddyObject user1 = new JeddyObject("user1");
user1.addNode("name", "John");
user1.addNode("age", "31");
user1.addNode("city", "Buea");

JeddyObject user2 = new JeddyObject("user2");
user2.addNode("name", "Simeon");
user2.addNode("age", "40");
user2.addNode("city", "Limbe");
		
JeddyObject user = new JeddyObject("users");
user.addNode("users", user1);
user.addNode("users", user2);

user.toJson()

Output: {"users":[{"name":"John","age":"31","city":"Buea"},{"name":"Simeon","age":"40","city":"Limbe"}]}


```

**Example 4** : An Object to Json Object output

```

public class User{
	private String name = "ET Tanko";
	private int age = 50;
	private String[] USstates = {"NY","LA","IL","IA"};
	private List<String> categories;
	
	public User(){
		categories = new ArrayList<String>();
		this.categories.add("Books");
		this.categories.add("Fashion");
		this.categories.add("Electronics");
		this.categories.add("Home");
	}
	...
}

```

Converting the User Object to a Json String with all the properties of the User Object

```
User user = new User();
JeddyObject obj = Jeddy.getJeddyObject(user);
obj.toJson();

Output: {"name":"ET Tanko","age":"30","USstates":["NY","LA","IL","IA"],"categories":["Books","Fashion","Electronics","Home"]}

```

Converting the User Object to a Json String without the 'USstates' and 'age' properties of the User Object

```
User user = new User();
JeddyObject obj = Jeddy.getJeddyObject(user, new String[] {"USstates","age"});
obj.toJson();

Output: {"name":"ET Tanko","categories":["Books","Fashion","Electronics","Home"]}

```


## Usage : XML String

**Example 1** : Simple XML Object output

```
JeddyObject user1 = new JeddyObject("user1");
user1.addNode("name", "John");
user1.addNode("age", "31");
user1.addNode("city", "Buea");

user1.toXml()

Output: 

<?xml version="1.0" encoding="UTF-8"?>
<user1>
	<name>John</name>
	<age>31</age>
	<city>Buea</city>
</user1>

```


**Example 2** : An array XML output

```
JeddyObject names = new JeddyObject();
names.addNode("names", "john");
names.addNode("names", "Edward");
names.addNode("names", "Jude");

names.toXml()

Output: 

<?xml version="1.0" encoding="UTF-8"?>
<data>
	<names>
		<value>john</value>
		<value>Edward</value>
		<value>Jude</value>
	</names>
</data>

```


**Example 3** : An Array of Xml Object output

```
JeddyObject user1 = new JeddyObject("user1");
user1.addNode("name", "John");
user1.addNode("age", "31");
user1.addNode("city", "Buea");

JeddyObject user2 = new JeddyObject("user2");
user2.addNode("name", "Simeon");
user2.addNode("age", "40");
user2.addNode("city", "Limbe");
		
JeddyObject user = new JeddyObject("users");
user.addNode("users", user1);
user.addNode("users", user2);

user.toXml()

Output: 

<?xml version="1.0" encoding="UTF-8"?>
<users>
	<users>
		<value>
			<user1>
				<name>John</name>
				<age>31</age>
				<city>Buea</city>
			</user1>
		</value>
		<value>
			<user2>
				<name>Simeon</name>
				<age>40</age>
				<city>Limbe</city>
			</user2>
		</value>
	</users>
</users>

```


**Example 4** : An Object to Xml String output

```

public class User{
	private String name = "ET Tanko";
	private int age = 50;
	private String[] USstates = {"NY","LA","IL","IA"};
	private List<String> categories;
	
	public User(){
		categories = new ArrayList<String>();
		this.categories.add("Books");
		this.categories.add("Fashion");
		this.categories.add("Electronics");
		this.categories.add("Home");
	}
	...
}

```

Converting the User Object to an Xml String with all the properties of the User Object

```
User user = new User();
JeddyObject obj = Jeddy.getJeddyObject(user);
obj.toXml();

Output: 

<?xml version="1.0" encoding="UTF-8"?>
<data>
	<name>ET Tanko</name>
	<age>50</age>
	<USstates>
		<value>NY</value>
		<value>LA</value>
		<value>IL</value>
		<value>IA</value>
	</USstates>
	<categories>
		<value>Books</value>
		<value>Fashion</value>
		<value>Electronics</value>
		<value>Home</value>
	</categories>
</data>

```

Converting the User Object to an Xml String without the 'USstates' and 'age' properties of the User Object

```
User user = new User();
JeddyObject obj = Jeddy.getJeddyObject(user, new String[] {"USstates","age"});
obj.toXml();

Output: 

<?xml version="1.0" encoding="UTF-8"?>
<data>
	<name>ET Tanko</name>
	<categories>
		<value>Books</value>
		<value>Fashion</value>
		<value>Electronics</value>
		<value>Home</value>
	</categories>
</data>

```




## Authors

* **Edward T. Tanko** - *Initial work* - [eddytnk](https://github.com/eddytnk)

See also the list of [contributors](https://github.com/eddytnk/Jeddy/graphs/contributors) who participated in this project.

## License

This project is licensed under the MIT License 








