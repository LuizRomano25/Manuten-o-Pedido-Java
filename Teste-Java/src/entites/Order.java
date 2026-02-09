package entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import Enum.OrderStatus;

public class Order{

    private LocalDate moment;

    private OrderStatus status;
    private List<OrderItem> orderItem = new ArrayList<>();
    private Client client;

    private DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy");

    public Order(){

    }

    public Order(LocalDate moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDate getMoment(){
        return moment;
    }
    
    public void setMoment(LocalDate moment){
        this.moment = moment;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

     public Client getClient(){
        return client;
    }

     public void setClient(Client client){
        this.client = client;
    }

    public void addItem(OrderItem item){
        orderItem.add(item);
    }

    public void remItem(OrderItem item){
        orderItem.remove(item);
    }

    public Double total(){
        double sum = 0.0;
        for(OrderItem item : orderItem){
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(LocalDate.now().format(fmt1) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : orderItem) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
