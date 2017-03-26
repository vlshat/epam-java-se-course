* class MedicalStaff{}
* class Doctor extends MedicalStaff{}
* class Nurse extends MedicalStaff{}
* class HeadDoctor extends Doctor{}

| |Correct|Not correct|Explanation|
|-|:-:|:-:|-|
| Doctor doctor1 = new Doctor(); |+| |Type of variable and object are the same|
|Doctor doctor2 = new MedicalStaff();| |+|Incompatible types|
|Doctor doctor3 = new HeadDoctor();|+| |Type of object is an heir of type of variable|
|Object object1 = new HeadDoctor();|+| |Type of object is an heir of type of variable|
|HeadDoctor doctor5 = new Object();| |+|Incompatible types|
|Doctor doctor6 = new Nurse();| |+|Incompatible types|
|Nurse nurse = new Doctor();| |+|Incompatible types|
|Object object2 = new Nurse();|+| |Type of object is an heir of type of variable|
| | | |
|List&lt;Doctor&gt; list1= new ArrayList&lt;Doctor&gt;();|+| |
|List&lt;MedicalStaff&gt; list2 = new ArrayList&lt;Doctor&gt;();| |+|Doctor higher in hierarchy
|List&lt;Doctor&gt; list3 = new ArrayList&lt;MedicalStaff&gt;();| |+|MedicalStaff higher in hierarchy
|List&lt;Object&gt; list4 = new ArrayList&lt;Doctor&gt;();| |+|MedicalStaff higher in hierarchy
|List&lt;Object&gt; list5 = new ArrayList&lt;Object&gt;();|+ | |
