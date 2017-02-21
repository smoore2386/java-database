
CREATE OR REPLACE 
PROCEDURE INSERTTEAM AS 
  tname varchar(255);
  ttype varchar(255);
  f_date date;
  PROCEDURE insertTeam (tname IN VARCHAR, ttype IN VARCHAR,
    f_date IN DATE) AS
    BEGIN
    INSERT INTO TEAMS(t_name,t_type,form_date)
    VALUES(tname,ttype,todate('f_date','yyyymmdd'));
    END;
END INSERTTEAM;