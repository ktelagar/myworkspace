package com.inverse.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.inverse.entities.DeliveryAssociate;
import com.inverse.entities.Parcel;
import com.inverse.helper.SessionFactoryRegistry;

public class InverseTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			Set<Parcel> parcels = new HashSet<>();
//			DeliveryAssociate deliveryAssociate = DeliveryAssociate.builder().associateName("micheal")
//					.contactNo("89737933").experience(15).designation("delivery agent").parcels(parcels).build();
//			// session.save(deliveryAssociate);
//
//			Parcel parcel1 = Parcel.builder().deliveryType("normal").weight(3).description("documents").charges(130)
//					.deliveryAssociate(deliveryAssociate).build();
//			session.save(parcel1);

			DeliveryAssociate deliveryAssociate = session.get(DeliveryAssociate.class, 7);

			Set<Parcel> parcels = deliveryAssociate.getParcels();
			Iterator<Parcel> it = parcels.iterator();
			while (it.hasNext()) {
				Parcel parcel = it.next();
				it.remove();
				//session.delete(parcel);
			}
			session.update(deliveryAssociate);

//			System.out.println("associate name: " + deliveryAssociate.getAssociateName());
//			Set<Parcel> parcels = deliveryAssociate.getParcels();
//			for (Parcel parcel : parcels) {
//				System.out.println(parcel);
//			}

//			Query query = session.createQuery("select da from DeliveryAssociate da where da.experience >= :exp");
//			query.setParameter("exp", 5);
//			List<DeliveryAssociate> deliveryAssociates = query.getResultList();
//			for (DeliveryAssociate deliveryAssociate : deliveryAssociates) {
//				System.out.println("associate name : " + deliveryAssociate.getAssociateName());
//				System.out.println("parcels: ");
//				Set<Parcel> parcels = deliveryAssociate.getParcels();
//				for (Parcel parcel : parcels) {
//					System.out.println(parcel);
//				}
//			}

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
