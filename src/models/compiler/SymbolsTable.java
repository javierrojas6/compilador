package compilador.models.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SymbolsTable {

    private ArrayList<Symbol> list;
    private HashMap<String, String> map;

    /**
     * Get the value of list
     *
     * @return the value of list
     */
    public ArrayList<Symbol> getList() {
        return list;
    }

    /**
     * Set the value of list
     *
     * @param list new value of list
     */
    public void setList(ArrayList<Symbol> list) {
        this.list = list;
        updateMap();
    }

    public String getToken(String lexema) {
        if (!map.containsKey(lexema)) {
            list.add(new Symbol(lexema, lexema, false));
            updateMap();
        }
        return map.get(lexema);
    }

    private void updateMap() {
        map = new HashMap<String, String>();
        Symbol tmp = null;
        Iterator<Symbol> it = list.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            map.put(tmp.getLexema(), tmp.getTokenId());
        }
    }

    public boolean isReserverWord(String lexema) {
        boolean ReserverWord= false;
        Symbol tmp = null;
        Iterator<Symbol> it= list.iterator();
        while (it.hasNext()){
            tmp=it.next();
               if(tmp.getLexema().equals(lexema)&& tmp.isReservedWord()){
                  ReserverWord= true;
                  break;
               }   
        }
        return ReserverWord;
    }
}
