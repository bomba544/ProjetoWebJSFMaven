package br.com.projeto.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

public class PhaseListener implements javax.faces.event.PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes da fase: "+getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            System.out.println("Depois da fase: "+getPhaseId());
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()){
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
                
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
