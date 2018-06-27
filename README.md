# MENAD_OnlineTests_19RT06Z18

for ACQUISIO

Steps to Get the App running:

In the project’s folder “Acquisio-Git”

1- Open CLI

2- go to /db-derby-10.14.1.0-bin/bin/

3- run $ ./startNetworkServer

4- Open a new CLI

4- go to /wildfly-11.0.0.Final/bin/

5- run $ ./standalone.sh -c standalone.xml

6- go to the URL:

http://localhost:8080/myapp/employees/
————->to get the list of employees and access them for modification.

http://localhost:8080/myapp/employees/register ————-> 
to register a new employee. 
http://localhost:8080/myapp/departments ————->to get the list of departments.
