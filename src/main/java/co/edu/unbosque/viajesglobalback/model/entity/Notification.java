package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.NotificationStatusEnum;
import co.edu.unbosque.viajesglobalback.model.enums.NotificationTypeEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {
	@Id
	@Column(name = "notification_id", nullable = false, columnDefinition = "VARCHAR(20)")
	private String notificationId;
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
	@Column(name = "notification_type", nullable = false)
	private NotificationTypeEnum notificationType;
	@Column(name = "content", nullable = false)
	private String content;
	@Column(name = "sent_date", nullable = false)
	private LocalDateTime sentDate;
	@Column(name = "status", nullable = false)
	private NotificationStatusEnum status;
	
	public Notification() {
		
	}

	public Notification(String notificationId, Customer customer, NotificationTypeEnum notificationType, String content,
			LocalDateTime sentDate, NotificationStatusEnum status) {
		super();
		this.notificationId = notificationId;
		this.customer = customer;
		this.notificationType = notificationType;
		this.content = content;
		this.sentDate = sentDate;
		this.status = status;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getSentDate() {
		return sentDate;
	}

	public void setSentDate(LocalDateTime sentDate) {
		this.sentDate = sentDate;
	}

	public NotificationStatusEnum getStatus() {
		return status;
	}

	public void setStatus(NotificationStatusEnum status) {
		this.status = status;
	}
}
