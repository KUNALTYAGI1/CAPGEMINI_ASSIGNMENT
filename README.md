# CAPGEMINI_ASSIGNMENT
*/This assignment include mongodb concept-/*
Find, Update, View, Insert, alter, aggreagate, Delete.

Java assignment 1 including core java concept.

Java assignment 2 includes oops concepts.

Java assignment 3 includes exception handling concept.

java assignement 4 and 5 includes colllections concepts.

Spring assignments includes core spring assignment where injection of object , autowiring through annotation and xml is done.


# GIT HUB COMMANDS
git status -> status

git config --gobal user.username -> add git username

git config --gobal user.email -> add git email

git config --local user.username -> add local device user

git commit -m "comment that show after compeletion" -> data commit

git remote add origin Add_Link -> Adding github repository link

git push origin master/main -> push all data from local folder to git rep

git init -> initialize git

git add File_name -> add file

git add -A ->add all file

git difftool Head -> diff b/w local ana workspace

git difftool -> diff b/w index stage and

git checkout Branch_name/master -> switch b/w branches

git pull origin master/main -> remote to workspace

git commit -a -> add and commit both

git fetch -> remote to local rep

git merge -> local to workspace

git log -all --decorate --oneline --graph -> check the head of branch

git branch Branch_name -> create Branch

git merge Branch_name -> merge branch in master / other branch

git branch --merged -> how many branch get merged

git branch -D Branch_name -> force delete branch

git branch -d Branch_name -> delete branch

git checkout -b branch_name -> create and checkout the branch

git checkout 965f32a -> check status of particular state and this is called detached head not pointing to master

git stash -> we can save new change to file and we will apply those changes in future

git stash list -p -> list all stash new change

git stash apply stash@{number} -> which stash u applying

git stash apply

git stash save "message"

git stash list

git checkout -b testing-rebase

git rebase master

# MONG0 BD

BSON -> Binary representation of JSON. (Increase speed and more space).

MongoDB use Collections for Storing Data.

MongoDB use CAP theorm { Consistency , Availabilty , Partition Tolerance }

Patterns in Mongo -> Schema Versioning , Subset , Computed , Bucket , Extended Reference

default port number : 27017

# MONGO SHELL COMMANDS
show dbs -> show databases

use first-test -> u can use an Database that doesn't exist

db.users.insertOne( { Name : 'Kunal' , Age ; 29 } ) -> add one object to data

db.users.insertMany( [ { Name : 'Kunal' , Age ; 29 } , { Name : 'Kunal' , Age ; 29 } ] ) -> add Many object to data

show collections -> show all collections we created (record)

db.collections -> give name to inplace of collections to record holder

db.users.find() -> find record inside

db.users.find( { Age : { $gt : 29 } } ) ->find data of Age is greater than 29 | gt = greatert than , lt = lower than , gte = greater than and equal to

db.users.insertOne({name: {F_Name : 'Kunal' , L_Name: 'Tyagi' },Age : 31 })

db.users.find({"name.F_Name" : 'Kunal'}) -> find sub record like name to first name

db.users.update({name:'Kunal'},{$set : {Age: 30}}) -> update record

db.users.deleteOne({name: 'Kunal Tyagi'}) ->delete one record

db.createCollection('Books') -> create Collection

db.dropDatabase() -> drop database

db.createCollection('Name',{ capped : true , size: give_size , max : give_limit }) -> CApped Collection , it will limit the collection size

db.users.find( { $or: [ { name : 'Manav' } , { Age : {$gt : 29 } } ] } ) -> filter using Or and And opretator
