# ShortRoid
##Android In Short

ShortRoid Library makes it esaier to use different functionalities of android. Main objective is to simplify android code and make the development process faster.
ShortRoid being open source encourages contributers to contribute and make it more fun for the developers to develop android apps using ShortRoid.

Following is the documentation for the library. It will be modified as more classess are added.

##Documentation

##ShortroidDB

An SqlLite library for integrating databases in applications.

##Usage Example
```
//Attributes are the columns in database table
HashMap<String,String> attributes = new HashMap<>();

// Assigning table attributes and their types

attributes.put("KEY",INTEGER);
attributes.put("NAME","TEXT");

// Creating database and table. It only takes one line of code
ShortRoidDB shortdb = new ShortRoidDB(MainActivity.this,DATABASE_NAME,1,TABLE_NAME,attributes);

```

##Inserting data - insert()
```
HashMap<String,String> data = new HashMap<>();

data.put("KEY",1);
data.put("NAME","Prashant");
shortdb.insert(data);

data.put("KEY",2);
data.put("NAME","Mohit");
shortdb.insert(data);
```
##Query data - query()
```
List< HashMap<String,String> > list;
String q = "SELECT * FROM TABLE_NAME";
list = shortdb.query(q);

for(HashMap<String,String> hmap:list){

    // hmap.get("Attribute_Name")
    // String name = hmap.get("NAME");
    // String key = hmap.get("KEY");

    s = s+hmap.get("NAME")+" "+hmap.get("KEY")+" \n";
  }
```
 
##Updating database - anyQuery()

```
String query = "UPDATE table_name
                SET column1 = value1, column2 = value2...., columnN = valueN
                WHERE [condition];"
                
shortdb.anyQuery(query)
```

##AnyQuery i.e Delete, Update, Alter etc - anyQuery()
```
String query = "DELETE FROM table_name
                WHERE [condition];"
shortdb.anyQuery(query);

```

##ShortRoidPreferences

A library to integrate SharedPreferences easily.

##Usage

```java 
ShortRoidPreferences shortRoidPreferences=new ShortRoidPreferences(context);

//Use Set methods to put values (key,value)
 shortRoidPreferences.setPrefString("Example","JustTesting");
 
//Use Get methods to get values (key) 
 shortRoidPreferences.getPrefString("Example");
```



