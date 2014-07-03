package com.xyz.myproject.model.projet;

/**
 * Les enums � faire passer en param�tre au patron observateur charg� de
 * mettre � jour les d�penses g�n�rales lors de mises � jour des d�penses par
 * projet.
 * 
 * EQ_50 : mise � jour du champ eqt_50, la location d'�quipement � plus de 50%
 * du temps de la RSDE 
 * 
 * EQ_90 : mise � jour du champ eqt_90, la location
 * d'�quipement � plus de 90% du temps de la RSDE 
 * 
 * ST_CA_DET : mise � jour du champ tsProjetCa, les salaires et traitements des employ�s 
 * d�termin�s ayant exerc� des activit�s de RSDE au Canada
 * 
 * ST_CA_NON_DET :mise � jour du champ tsProjetCa, les salaires et traitements des employ�s non
 * d�termin�s ayant exerc� des activit�s de RSDE au Canada
 * 
 * ST_ETR_DET : mise � jour du champ tsProjetEtr, les salaires et traitements
 * des employ�s d�termin�s ayant exerc� des activit�s de RSDE � l'�tranger
 * 
 * ST_ETR_NON_DET : mise � jour du champ tsProjetEtr, les salaires et traitements
 * des employ�s d�termin�s ayant exerc� des activit�s de RSDE � l'�tranger
 * 
 * ST_RSDE : mise � jour du champ sout_rd, les d�penses de sous-traitance RD
 * 
 * ST_SOUT : mise � jour du champ sout_soutien, les d�penses de sous-traitance
 * de soutien
 * 
 * CHGT_PROJET : changement dans la liste des projets. Signifie qu'il y a un nouveau projet dans
 * la liste ou qu'un projet a �t� supprim�. 
 * 
 * MAT_CONSO : changement dans le montant des mat�riaux consomm�s
 * 
 * MAT_TRANSF : changement du montant des mat�riaux transform�s
 * 
 * MO_SOUT : MAJ de la main d'oeuvre de soutien.
 * 
 * 
 * @author Raoul
 * 
 */
public enum EVENT_DEP {
	EQ_50, EQ_90, ST_CA_DET, ST_CA_NON_DET, ST_ETR_DET, ST_ETR_NON_DET, MO_SOUT, ST_RSDE, ST_SOUT,CHGT_PROJET, MAT_CONSO, MAT_TRANSF ;

}
