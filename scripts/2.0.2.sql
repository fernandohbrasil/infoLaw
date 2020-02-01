ALTER TABLE conta ALTER COLUMN obs TO obs_old;
ALTER TABLE CONTA ADD OBS BLOB SUB_TYPE 1 SEGMENT SIZE 16384 CHARACTER SET ISO8859_1;
update conta set obs = obs_old;
ALTER TABLE conta drop obs_old;

update conta set conta.entidadeid = 11 where conta.entidadeid = 62;
update conta set conta.entidadeid = 154 where conta.entidadeid = 162;
update conta set conta.entidadeid = 153 where conta.entidadeid = 161;
update conta set conta.entidadeid = 81 where conta.entidadeid = 87;
update conta set conta.entidadeid = 45 where conta.entidadeid = 116;
update conta set conta.entidadeid = 27 where conta.entidadeid = 148;

delete from entidade where entidade.id in (62,162,161,87,116,148);

update filial set filial.versao = '2.0.2';  