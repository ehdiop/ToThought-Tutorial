package com.xyz.myproject.model.projet;

/**
 * Les enums à faire passer en paramètre au patron observateur chargé de
 * mettre à jour les dépenses générales lors de mises à jour des dépenses par
 * projet.
 * 
 * EQ_50 : mise à jour du champ eqt_50, la location d'équipement à plus de 50%
 * du temps de la RSDE 
 * 
 * EQ_90 : mise à jour du champ eqt_90, la location
 * d'équipement à plus de 90% du temps de la RSDE 
 * 
 * ST_CA_DET : mise à jour du champ tsProjetCa, les salaires et traitements des employés 
 * déterminés ayant exercé des activités de RSDE au Canada
 * 
 * ST_CA_NON_DET :mise à jour du champ tsProjetCa, les salaires et traitements des employés non
 * déterminés ayant exercé des activités de RSDE au Canada
 * 
 * ST_ETR_DET : mise à jour du champ tsProjetEtr, les salaires et traitements
 * des employés déterminés ayant exercé des activités de RSDE à l'étranger
 * 
 * ST_ETR_NON_DET : mise à jour du champ tsProjetEtr, les salaires et traitements
 * des employés déterminés ayant exercé des activités de RSDE à l'étranger
 * 
 * ST_RSDE : mise à jour du champ sout_rd, les dépenses de sous-traitance RD
 * 
 * ST_SOUT : mise à jour du champ sout_soutien, les dépenses de sous-traitance
 * de soutien
 * 
 * CHGT_PROJET : changement dans la liste des projets. Signifie qu'il y a un nouveau projet dans
 * la liste ou qu'un projet a été supprimé. 
 * 
 * MAT_CONSO : changement dans le montant des matériaux consommés
 * 
 * MAT_TRANSF : changement du montant des matériaux transformés
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
