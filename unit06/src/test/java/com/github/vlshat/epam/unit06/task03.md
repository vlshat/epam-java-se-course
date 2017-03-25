class MedicalStaff{}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}

||Correct|Not correct|Explanation|
|-|:-:|:-:|-|
| Doctor doctor1 = new Doctor(); |+||Type of variable and object are the same
|Doctor doctor2 = new MedicalStaff();||+|Incompatible types
|Doctor doctor3 = new HeadDoctor();|+||Type of object is an heir of type of variable
|Object object1 = new HeadDoctor();|+||Type of object is an heir of type of variable
|HeadDoctor doctor5 = new Object();||+|Incompatible types
|Doctor doctor6 = new Nurse();||+|Incompatible types
|Nurse nurse = new Doctor();||+|Incompatible types
|Object object2 = new Nurse();|+||Type of object is an heir of type of variable
||||
|List<Doctor> list1= new ArrayList<Doctor>();|+||
|List<Doctor> list3 = new ArrayList<MedicalStaff>();||+|MedicalStaff higher in hierarchy
|List<Object> list4 = new ArrayList<Doctor>();||+|MedicalStaff higher in hierarchy
|List<Object> list5 = new ArrayList<Object>();|+||