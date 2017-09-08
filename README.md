# java-execute-shell
This project is used to prove out that Java can indeed launch an external executable application/script.

Main - launches notepad.exe 
LaunchSpringbootApp -launches a local springboot application

To find process IDs or rogue process bound to a port no:
netstat -a -b -o | grep 8080