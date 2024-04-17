package com.library.LMS.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class BorrowedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "library_item_id")
    private Books libraryItem;

    @Temporal(TemporalType.DATE)
    private Date checkoutDate;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    private boolean returned;

    // Constructors
    public BorrowedItem() {
    }

    public BorrowedItem(User user, Books libraryItem, Date checkoutDate, Date dueDate, boolean returned) {
        this.user = user;
        this.libraryItem = libraryItem;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Books getLibraryItem() {
        return libraryItem;
    }

    public void setLibraryItem(Books libraryItem) {
        this.libraryItem = libraryItem;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    // toString() method
    @Override
    public String toString() {
        return "BorrowedItem{" +
                "id=" + id +
                ", user=" + user +
                ", libraryItem=" + libraryItem +
                ", checkoutDate=" + checkoutDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                '}';
    }
}
