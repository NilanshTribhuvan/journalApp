/*package net.engineeringdigest.journalApp.controller;

import entity.com.nilanshki.journalApp.JournalEntry;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<Long,JournalEntry> journalEntries =new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){

        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
     public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
     }

     @GetMapping("/id/{myId}")
     public JournalEntry getJournalEntryById(@PathVariable Long myId){

        return journalEntries.get(myId);
     }

     @DeleteMapping("/id/{myId}")
     public JournalEntry deleteJournalEntry(@PathVariable Long myId){

        return journalEntries.remove(myId);
     }
     @PutMapping("/id/{id}")
     public JournalEntry updateJournalEntry(@PathVariable Long id,@RequestBody JournalEntry myEntry){
       return journalEntries.put(id,myEntry);
     }
}
*/