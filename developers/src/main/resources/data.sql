INSERT INTO Developer(id,name,firstname,age,gender) VALUES (1,'HEJJAMY1','ILIAS1',26,0)
INSERT INTO Developer(id,name,firstname,age,gender) VALUES (2,'HEJJAMY2','ILIAS2',26,0)
INSERT INTO Developer(id,name,firstname,age,gender) VALUES (3,'HEJJAMY3','ILIAS3',26,0)

INSERT INTO Lang(id,name,description) VALUES (1,'langage1','description1')
INSERT INTO Lang(id,name,description) VALUES (2,'langage2','description2')

INSERT INTO developer_language(developer_id,language_id) VALUES (1,1)
INSERT INTO developer_language(developer_id,language_id) VALUES (1,2)
INSERT INTO developer_language(developer_id,language_id) VALUES (2,1)
INSERT INTO developer_language(developer_id,language_id) VALUES (3,2)