As the name of this project suggests, it is a dead simple Web Scrapper written in Java. It accepts a URL, validates it. Upon successful validation
it connects to that URL, parses the contents (without HTML tags obviously) belonging to it and stores them to a .txt file locally. 

After that, the contents are loaded from that file and they are stored into a DB (MySQL in this case) and indexed in the DB. Besides, it ranks a given searchword on the basis of its occurrence(s).

The project needs the following jar files to be configured in its classpath:

1. Jsoup
2. Oro
3. MySQL Connector
4. SLF4J-Logback
