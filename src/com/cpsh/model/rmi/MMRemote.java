package com.cpsh.model.rmi;
import java.rmi.Remote; 
import java.rmi.RemoteException;

public interface MMRemote extends Remote {
	public MMSubmitRes submit(Object o) throws RemoteException;
	public MMSubmitRes submit(Object o,int priority) throws RemoteException;
	public String view()throws RemoteException;
}
