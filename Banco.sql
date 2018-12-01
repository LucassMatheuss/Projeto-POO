CREATE TABLE POO_Pessoa (	
			CPF 		varchar2(11),
            Nome        varchar2(30)       NOT NULL, 
			DataNasc    varchar2(10)       NOT NULL, 
			Endereco    varchar2(30)       NOT NULL,
			Numero      number(8)          NOT NULL,
			Bairro      varchar2(30)       NOT NULL,
			Cidade      varchar2(30)       NOT NULL,
			Estado      varchar2(45),
			CEP         varchar2(15)       NOT NULL,
			Telefone    varchar2(15),
			Celular     varchar2(15),
			Sexo        varchar2(10)        CHECK (Sexo IN ('Masculino','Feminino')),
			EstadoCivil varchar2(30),
			RG          varchar2(15)       NOT NULL,
			Email       varchar2(40)       UNIQUE,
			CONSTRAINT pk_CPF PRIMARY KEY(CPF)	);

CREATE TABLE POO_Instrutor ( 	
			CPFInstrutor varchar2(11) NOT NULL,
            Formacao    varchar2(30),
			AreaAtuacao varchar2(30)  NOT NULL,
			CONSTRAINT pk_CPFInstrutor PRIMARY KEY (CPFInstrutor)	);

CREATE TABLE POO_Aluno (	
			CPFAluno varchar2(17) NOT NULL,
			Escolaridade varchar2(30),
			CONSTRAINT pk_CPFAluno PRIMARY KEY(CPFAluno));

CREATE TABLE POO_Matricula (	
			CPFAluno 			varchar2(11) 	  NOT NULL,
            SiglaTurma    		varchar2(4)       NOT NULL,
			CodPagamentoVista 	number(9),
			CodPagamentoPrazo 	number(9),
            DataMatricula 		varchar2(10),
            QtdeFaltas    		number(7),
            Nota          		number(4,2),
            CONSTRAINT pk_CPFAlunoMatricula PRIMARY KEY(CPFAluno));

CREATE TABLE POO_APrazo (	
			CodPagamento 	number(9) 		NOT NULL,
            Valor           number(7,2),
			DtVencimento    varchar2(10),
			TaxaJuros       number(7,2),
			QtdeMensalidade number(7),
            CONSTRAINT pk_CodPagamentoAPrazo PRIMARY KEY(CodPagamento));

CREATE TABLE POO_AVista (	
			CodPagamento 	number(9) 		 NOT NULL,
            Valor        	number(7,2),
			Agencia      	number(7),
			NCheque     	number(7),
			PreData      	varchar2(10),
            CONSTRAINT pk_CodPagamentoAVista PRIMARY KEY(CodPagamento));

CREATE TABLE POO_Turma (	
			SiglaTurma varchar2(10),
            CPFInstrutor varchar2(11),
            SiglaCurso   varchar(10),
			Nome    varchar2(30),
			DataInicio   varchar2(16),
			DataTermino  varchar2(16),
			Periodo      varchar2(10) CHECK (Periodo IN ('Manha','Tarde','Noite')),
			QtdeVagas     number(3),
			Observacoes  varchar2(30),
            CONSTRAINT pk_SiglaTurma PRIMARY KEY(SiglaTurma));

CREATE TABLE POO_Curso (	
			Sigla 			   varchar2(10),
			Nome               varchar2(40),
			CargaHoraria       number(5),
			Valor              number(7,2),
			DataVigencia       varchar2(16),
			ValorHoraInstrutor number(7,2),
			Programa           varchar2(30),
            CONSTRAINT pk_Sigla PRIMARY KEY(Sigla));

/*######################################################################################
###############################  Cardinalidades ########################################## */
ALTER TABLE POO_Instrutor ADD (	CONSTRAINT fk_InstrutorPessoa FOREIGN KEY (CPFInstrutor)
				REFERENCES POO_Pessoa (CPF) ON DELETE CASCADE);

ALTER TABLE POO_Aluno ADD (	CONSTRAINT fk_AlunoPessoa FOREIGN KEY (CPFAluno)
				REFERENCES POO_Pessoa (CPF) ON DELETE CASCADE); 

ALTER TABLE POO_Matricula ADD (	CONSTRAINT fk_CpfAlunoMatricula FOREIGN KEY (CPFAluno)
				REFERENCES POO_Aluno (CPFAluno) ON DELETE CASCADE);
            
ALTER TABLE POO_Matricula ADD (	CONSTRAINT fk_SiglaTurmaMatricula FOREIGN KEY (SiglaTurma)
				REFERENCES POO_Turma (SiglaTurma) ON DELETE CASCADE);

ALTER TABLE POO_Matricula ADD ( CONSTRAINT fk_CodPagamentoVista FOREIGN KEY(CodPagamentoVista)
				REFERENCES POO_AVista (CodPagamento) ON DELETE CASCADE);

ALTER TABLE POO_Matricula ADD ( CONSTRAINT fk_CodPagamentoPrazo FOREIGN KEY(CodPagamentoPrazo)
				REFERENCES POO_APrazo (CodPagamento) ON DELETE CASCADE);

                
ALTER TABLE POO_Turma ADD (	CONSTRAINT fk_CPFInstrutorTurma FOREIGN KEY (CPFInstrutor)
				REFERENCES POO_Instrutor (CPFInstrutor) ON DELETE CASCADE);

ALTER TABLE POO_Turma ADD (	CONSTRAINT fk_SiglaCursoTurma FOREIGN KEY (SiglaCurso)
				REFERENCES POO_Curso (Sigla) ON DELETE CASCADE);
                