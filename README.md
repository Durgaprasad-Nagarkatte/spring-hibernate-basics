# spring-hibernate-basics
https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/junit5.md


The entire code present in the method is considered as a single transaction, both the insert and update command is executed.
```
public void playWithEntityManager(){
  Course course = new Course("Web Services course");
  em.persist(course);
  course.setName("Web Services course updated");
 ```
 
 
