--Creating table Register for storing login credentials
CREATE TABLE lib1
(
 USERNAME VARCHAR(30),
 EMAIL VARCHAR(30),
 PASSWORD VARCHAR(30),
 MOBILE  VARCHAR(11)
);

--Creating table Books
CREATE TABLE Books
(
 BK_ID VARCHAR(20) PRIMARY KEY,
 BK_NAME VARCHAR(30),
 BK_AUTOR VARCHAR(30),
 BK_PUB VARCHAR(40),
 BK_PRICE VARCHAR(40),
 BK_QTY VARCHAR(10)
);
--Creating table IssBK_BORROWEDued_Books
CREATE TABLE Issued_Books
(
 BK_ID VARCHAR(20) ,
 BK_NAME VARCHAR(40),
 BOR_ID VARCHAR(20),
 BOR_NAME VARCHAR(50),
 BOR_CONTACT VARCHAR(40),
 ISS_DATE DATE,
 RET_DATE DATE,
 FOREIGN KEY(BK_ID) references Books(BK_ID),
 FOREIGN KEY(BOR_ID) references Borrowers(BOR_ID)
);

--Creating table Borrowers
CREATE TABLE Borrowers
(
 BOR_ID VARCHAR(20) PRIMARY KEY,
 BOR_NAME VARCHAR(50),
 BOR_ADDRESS VARCHAR(60)
 BOR_EMAIL VARCHAR(40),
 BOR_CONTACT VARCHAR(40),
 BK_BORROWED VARCHAR(20),
 FINE_AMT VARCHAR(25)
)

--inserting into books
insert into books values(01,'The Alchemist','Paulo Coelho','HarperTorch','500','10');
insert into books values(02,'Harry Porter','Harry Porter','Bloomsbury','1000','10');
insert into books values(03,'The Brief History of Time','Stephan Hawlking','Bantam Dell','1400','10');
insert into books values(04,'Wings Of Fire','A.P.J.Abdul Kalam','Cocoblu','600','10');
insert into books values(05,'The World As I See It','Albert Einsten','The Bodley Head','400','10');
insert into books values(06,'Demystifying Computer','Achut Godbole','Tata Mcgraw-Hill','450','10');
insert into books values(07,'Mein Kamf','Adolf Hitler','Franz Eher Nachfolger','1600','10');
insert into books values(08,'Indian Polity','M. Lakshmikant','K Sagar','560','10');
insert into books values(09,'Renaissance State','Girish Kuber','Harper Collins','700','10');
insert into books values(10,'The Discoverry of India','Jawarlal Nehru','Platkus','800','10');

--inserting into Borrowers
insert into Borrowers values(01,'Vinay Hajare','Kanersar, Khed, Pune','vinayhajare2004@gmail.com','7559282625','0','0');

--inserting into issued_books
insert into issued_books values(01,'The Alchemist',01,'Vinay Hajare','7559282625',curdate(),curdate()+3);
insert into issued_books values(02,'Harry Porter',01,'Vinay Hajare','7559282625',curdate(),curdate());
insert into issued_books values(04,'Wings Of Fire',01,'Vinay Hajare','7559282625',curdate(),curdate()-3);
