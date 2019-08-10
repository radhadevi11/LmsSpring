class Student{
    constructor(firstName,lastName,gender,mailId,collegeName,password) {
                       this.firstName = firstName;
                       this.lastName = lastName;
                       this.gender = gender;
                       this.mailId = mailId;
                       this.collegeName = collegeName;
                       this.password = password;
  }

}
    function saveStudent(){
         var request = new XMLHttpRequest();
         request.open('POST','http://localhost:8080/students',false);
         var firstName = document.getElementById('firstName').value;
         var lastName = document.getElementById('lastName').value;
         var genderList = document.getElementsByName("Gender");
         var gender;
          for(var i=0; i<genderList.length; i++){
          	if(genderList[i].checked){
            	gender=genderList[i].value;
               }
             }
         var emailId = document.getElementById('email').value;
         var collegeName = document.getElementById('collegeName').value;
         var password = document.getElementById('password').value;

         var student = new Student(firstName, lastName, gender, emailId, collegeName, password);
         var studentString = JSON.stringify(student);
         request.setRequestHeader("Content-type", "application/json");
         request.send(studentString);
    }

