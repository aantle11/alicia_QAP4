This Assignment is a golf club api that is spring boot based and manages golf tournaments and players, it provides CRUD operations for players and tournaments and supports search through endpoints, the api has been configured to connect to a RDS instance.

Search Features
/tournaments - retrieves all tournaments     
/tournaments/{id} - retrieves tournament by id
/players - retrieves all players
/players/{id} - retrieves player by id
/tournaments/search?name={name} - search tournament by name
/players/search?name={name} - search player by name

I had issues running the project with docker as i had to enable something in bios, screenshot provided in the images folder while in there i could not figure out how to enable virtualization i reached out for help but was unable to fix it.

AWS Deployment
ec2 instance was created
rds instance was created and security groups were configured
application.properties was updated to use the rds endpoint instead of the local database

Issues Faced:
1. Sudo disabled on local machine: had to enable developer settings in windows to gain permissions
2. Key Pair - when creating the ec2 instance my key pair wasnt downloaded so i had to create a new key pair and attach it

Screenshots of Postman testing, docker, and deployment steps taken are all in Images



