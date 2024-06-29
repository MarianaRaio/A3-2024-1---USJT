CREATE DATABASE sistema;
USE sistema;

CREATE TABLE usuarios (
id INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(100),
nome VARCHAR(100),
email VARCHAR(100),
senha VARCHAR(100),
telefone VARCHAR(45)
);
CREATE TABLE projetos (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
tipo VARCHAR(100)
);
CREATE TABLE subprojetos (
id INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(400),
id_subprojetos INT,
FOREIGN KEY (id_projetos) REFERENCES projetos(id)
);
CREATE TABLE salvaprojetos (
id_projetos INT,
id_subprojetos INT,
avaliacao DOUBLE,
descricao_proj VARCHAR(1000),
id_descricaoproj INT PRIMARY KEY AUTO_INCREMENT,
FOREIGN KEY (id_projetos) REFERENCES projetos(id),
FOREIGN KEY (id_subprojetos) REFERENCES subprojetos(id)
);

-- povoamento --
-- ODS escolhida: ODS 3 - Saúde e Bem-Estar --
INSERT INTO projetos (id, nome, tipo) 
VALUES (1, 'Erradicação da Pobreza', ODS),
(2, 'Fome Zero e Agricultura Sustentável', ODS),
(3, 'Saúde e Bem-Estar', ODS),
(4, 'Educação de Qualidade', ODS),
(5, 'Igualdade de Gênero', ODS),
(6, 'Água Potável e Saneamento', ODS),
(7, 'Energia Limpa e Acessível', ODS),
(8, 'Trabalho Decente e Crescimento Econômico', ODS),
(9, 'Indústria, Inovação e Infraestrutura', ODS),
(10, 'Redução das Desigualdades', ODS),
(11, 'Cidades e Comunidades Sustentáveis', ODS),
(12, 'Consumo e Produção Responsáveis', ODS),
(13, 'Ação Contra A Mudança Global Do Clima', ODS),
(14, 'Vida na Água', ODS),
(15, 'Vida Terrestre', ODS),
(16, 'Paz, Justiça e Instituições Eficazes', ODS),
(17, 'Parcerias e Meios de Implementação', ODS);

-- projetos escolhidos: 3.5 e 3.6 --
 INSERT INTO subprojetos (id, descricao, id_projetos)
 VALUES (1, 'Até 2030, reduzir a taxa de mortalidade materna global para menos de 70 mortes por 100.000 nascidos vivos', 3),
 (2, 'Até 2030, acabar com as mortes evitáveis de recém-nascidos e crianças menores de 5 anos, com todos os países objetivando reduzir a mortalidade neonatal para pelo menos 12 por 1.000 nascidos vivos e a mortalidade de crianças menores de 5 anos para pelo menos 25 por 1.000 nascidos vivos', 3),
 (3, 'Até 2030, acabar com as epidemias de AIDS, tuberculose, malária e doenças tropicais negligenciadas, e combater a hepatite, doenças transmitidas pela água, e outras doenças transmissíveis',3),
 (4, 'Até 2030, reduzir em um terço a mortalidade prematura por doenças não transmissíveis via prevenção e tratamento, e promover a saúde mental e o bem-estar', 3),
 (5, 'Reforçar a prevenção e o tratamento do abuso de substâncias, incluindo o abuso de drogas entorpecentes e uso nocivo do álcool', 3),
 (6, 'Até 2020, reduzir pela metade as mortes e os ferimentos globais por acidentes em estradas', 3),
 (7, 'Até 2030, assegurar o acesso universal aos serviços de saúde sexual e reprodutiva, incluindo o planejamento familiar, informação e educação, bem como a integração da saúde reprodutiva em estratégias e programas nacionais', 3),
 (8, 'Atingir a cobertura universal de saúde, incluindo a proteção do risco financeiro, o acesso a serviços de saúde essenciais de qualidade e o acesso a medicamentos e vacinas essenciais seguros, eficazes, de qualidade e a preços acessíveis para todos', 3),
 (9, 'Até 2030, reduzir substancialmente o número de mortes e doenças por produtos químicos perigosos, contaminação e poluição do ar e água do solo', 3);
 
 -- permissão de administrador -- 
 INSERT INTO usuarios (id, usuario, nome, email, senha, telefone, permissao)
 VALUES (1, 'adm1', 'adm', 'adm@gmail.com', '123', '(11) 11111-1111', 'adm');
 



