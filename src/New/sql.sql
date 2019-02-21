CREATE TABLE Angry(
id number(6) primary key,
breakAvailable number(6),
angry_index number(6)
);

create table Soldier(
id number(6) primary key,
name varchar2(16),
age number(6),
rank varchar2(16),
join_date date,
discharge_date date,
reigster date,
department number(6)
);



CREATE TABLE Salary(
rank varchar2(16),
salary number(10)
);

INSERT INTO Salary VALUES('이등병', 50000);
INSERT INTO Salary VALUES('일병', 100000);
INSERT INTO Salary VALUES('상병', 150000);
INSERT INTO Salary VALUES('병장', 200000);

CREATE TABLE Department (
depID number(4),
darName varchar(30)
);

INSERT INTO Department VALUES(1111, '소총');                                    
INSERT INTO Department VALUES(1112, 'M60기관총');                         
INSERT INTO Department VALUES(1113, '50MG기관총');                       
INSERT INTO Department VALUES(1114, '60미리박격포');                    
INSERT INTO Department VALUES(1119, '전투경찰');                            
INSERT INTO Department VALUES(1121, '57미리무반동총');                 
INSERT INTO Department VALUES(1122, '90미리무반동총');                  
INSERT INTO Department VALUES(1123, '106미리무반동총');                
INSERT INTO Department VALUES(1124, '81미리박격포');                     
INSERT INTO Department VALUES(1125, '4.2인치박격포');
INSERT INTO Department VALUES(1126, '대전차유도탄');
INSERT INTO Department VALUES(1127, '고속유탄기관총');
INSERT INTO Department VALUES(1131, '특전정작');
INSERT INTO Department VALUES(1132, '특전폭파');
INSERT INTO Department VALUES(1133, '특전통신');
INSERT INTO Department VALUES(1135, '낙하산 정비');
INSERT INTO Department VALUES(1134, '특전화기');
INSERT INTO Department VALUES(1136, '특전의무');



