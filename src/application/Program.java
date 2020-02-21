package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data de Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de Check-out tem que ser depois da data de check-in.");
		}
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
	        System.out.println("Reserva : " + reserva);
	        
	        System.out.println();
	        System.out.println("Entre com as novas data para atualizar a reserva:");
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	        
     		String error = reserva.atualizaData(checkIn, checkOut);
     		if (error != null) {
     			System.out.println("Erro na reserva : " + error);
     		}
     		else {
    	        System.out.println("Reserva : " + reserva);
     		}
		}
		
		sc.close();
	}

}
