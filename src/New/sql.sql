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

INSERT INTO Salary VALUES('�̵', 50000);
INSERT INTO Salary VALUES('�Ϻ�', 100000);
INSERT INTO Salary VALUES('��', 150000);
INSERT INTO Salary VALUES('����', 200000);

CREATE TABLE Department (
depID number(4),
darName varchar(30)
);

INSERT INTO Department VALUES(1111, '����');                                    
INSERT INTO Department VALUES(1112, 'M60�����');                         
INSERT INTO Department VALUES(1113, '50MG�����');                       
INSERT INTO Department VALUES(1114, '60�̸��ڰ���');                    
INSERT INTO Department VALUES(1119, '��������');                            
INSERT INTO Department VALUES(1121, '57�̸����ݵ���');                 
INSERT INTO Department VALUES(1122, '90�̸����ݵ���');                  
INSERT INTO Department VALUES(1123, '106�̸����ݵ���');                
INSERT INTO Department VALUES(1124, '81�̸��ڰ���');                     
INSERT INTO Department VALUES(1125, '4.2��ġ�ڰ���');
INSERT INTO Department VALUES(1126, '����������ź');
INSERT INTO Department VALUES(1127, '�����ź�����');
INSERT INTO Department VALUES(1131, 'Ư������');
INSERT INTO Department VALUES(1132, 'Ư������');
INSERT INTO Department VALUES(1133, 'Ư�����');
INSERT INTO Department VALUES(1135, '���ϻ� ����');
INSERT INTO Department VALUES(1134, 'Ư��ȭ��');
INSERT INTO Department VALUES(1136, 'Ư���ǹ�');



