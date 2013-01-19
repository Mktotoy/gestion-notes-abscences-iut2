package model;


import java.util.ArrayList;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * Tableau note
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Thu Jan 10 11:37:58 CET 2013]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Note
    extends model.BaseNote
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1357814278388L;


    /**
     * Return list of Notes for a etudiantId sent
     *
     * @return List<Note>
     */
	public static List<Note> getNotesEtudiant(int etudiantId) throws TorqueException
    {
    	List<Note> notes = new ArrayList<Note>();
    	Etudiant etudiant = EtudiantPeer.retrieveByPK(etudiantId);
		List<Note> listNotes = etudiant.getNotes();
		for(Note note : listNotes){
			notes.add(note);
		}
		return notes;
    }
    
    /**
     * Return list of Notes for a etudiantId and matiereId sent
     *
     * @return List<Note>
     */
	public static List<Note> getNotesEtudiantForMatiere(int etudiantId, int matiereId) throws TorqueException
    {
    	List<Note> notes = new ArrayList<Note>();
    	Etudiant etudiant = EtudiantPeer.retrieveByPK(etudiantId);
		List<Note> listNotes = etudiant.getNotes();
		for(Note note : listNotes){
			if(note.getMatiereId()==matiereId)
				notes.add(note);
		}
		return notes;
    }
    
    /**
     * Return list of Notes for a groupeId sent
     *
     * @return List<Note>
     */
	public static List<Note> getNotesGroupe(int groupeId) throws TorqueException
    {
    	List<Note> notes = new ArrayList<Note>();
    	Groupe groupe = GroupePeer.retrieveByPK(groupeId);
		List<Etudiant> listEtu = groupe.getEtudiants();
		for(Etudiant etu : listEtu){
			List<Note> listNotes = etu.getNotes();
			for(Note note : listNotes){
				notes.add(note);
			}
		}
		return notes;
    }
    
    /**
     * Return list of Notes for a groupeId and matiereId sent
     *
     * @return List<Note>
     */
	public static List<Note> getNotesGroupeForMatiere(int groupeId, int matiereId) throws TorqueException
    {
    	List<Note> notes = new ArrayList<Note>();
    	Groupe groupe = GroupePeer.retrieveByPK(groupeId);
			List<Etudiant> listEtu = groupe.getEtudiants();
			for(Etudiant etu : listEtu){
				List<Note> listNotes = etu.getNotes();
				for(Note note : listNotes){
					if(note.getMatiereId()==matiereId)
						notes.add(note);
				}
			}
		return notes;
    }
}
