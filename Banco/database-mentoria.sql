-- desc 
CREATE TABLE tb_person (
	idt_person          SERIAL PRIMARY KEY,
  	desc_name     		VARCHAR(255) NOT NULL,
  	desc_cpf     		VARCHAR(14) UNIQUE NOT NULL,
  	desc_address  		VARCHAR(255),
    desc_phone    		VARCHAR(15)
);

CREATE TABLE tb_student (
  idt_student  INT PRIMARY KEY,
  fk_class_id  INT,
  fk_mentor_id INT,
  
  CONSTRAINT  fk_student_person
  FOREIGN KEY (idt_student) 
  REFERENCES  tb_person(idt_person),
  
  
  CONSTRAINT  fk_class_id
  FOREIGN KEY (fk_class_id) 
  REFERENCES  tb_class(idt_class),
  
  
  CONSTRAINT   fk_mentor_id
  FOREIGN KEY (fk_mentor_id) 
  REFERENCES  tb_mentor(idt_mentor)
);

CREATE TABLE tb_mentor(
	idt_mentor INT,
  
  	CONSTRAINT  fk_mentor_person
    FOREIGN KEY (idt_mentor) 
    REFERENCES  tb_pessoa(idt_person)
);

CREATE TABLE tb_mentor_student (
	fk_STUDENT unique
  	fk_mentor check (COUNT(fk_mentor) <= 3)
  
  	
  
  	
  	

);


CREATE TABLE tb_class(
  idt_class SERIAL PRIMARY KEY,
  desc_school_year VARCHAR(25), 
);



CHECK (COUNT() <= 3 AND COUNT()))


--- fazer um count na coluna fk_mentor com 
--- fazer um trigger -> count no select com where restringindo o id que será inserido
--- 













