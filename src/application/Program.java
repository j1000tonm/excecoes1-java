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
	        
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: Datas da reserva para atualizar deve ser datas futuras.");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data de Check-out tem que ser depois da data de check-in.");			
			}
			else {
     			reserva.atualizaData(checkIn, checkOut);
    	        System.out.println("Reserva : " + reserva);
			}
		}
		
		sc.close();
	}

}
