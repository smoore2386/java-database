CREATE OR REPLACE PROCEDURE QUERY10
(SSN_O IN INTEGER,
DOC_NAME_O OUT VARCHAR,
DOC_PHONE_O OUT INTEGER
)
AS

docn varchar(255);
docp integer;
BEGIN
select doc_name, doc_phone into docn, docp
FROM CLIENT
WHERE ssn=SSN_O;

doc_phone_o := docp;
doc_name_o := docn;

END QUERY10;