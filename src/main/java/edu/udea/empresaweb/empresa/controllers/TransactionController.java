package edu.udea.empresaweb.empresa.controllers;



import edu.udea.empresaweb.empresa.entities.Transaction;
import edu.udea.empresaweb.empresa.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

    public class TransactionController {
    @Autowired
    TransactionService transactionService;


    @GetMapping("/movements")
    public String viewPageTransaction(Model model){
        model.addAttribute("listTransactions", transactionService.getAllTransactions());
        return "index2";
    }
    @GetMapping("/showNewTransactionForm")
    public String showNewTransactionForm(Model model) {
        // create model attribute to bind form data
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "new_transaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        // save transaction to database
        transactionService.saveTransaction(transaction);
        return "redirect:/movements";
    }

    @GetMapping("/updateTransaction/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        // get transaction from the service
        Transaction transaction = transactionService.getTransactionById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("transaction", transaction);
        return "update_transaction";
    }


    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable (value = "id") long id) {
        // call delete employee method
        this.transactionService.deleteTransactionById(id);
        return "redirect:/movements";
    }
}





