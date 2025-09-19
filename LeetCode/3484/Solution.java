class Spreadsheet {
    Map<String, Integer> sheet = new HashMap<>();
    public Spreadsheet(int rows) {
        sheet.clear();
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell, value);
    }
    
    public void resetCell(String cell) {
        sheet.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] split = formula.substring(1).split("\\+");
        int left = 0;
        int right = 0;
        if(split[0].charAt(0) >= 'A' && split[0].charAt(0) <= 'Z') {
            left = sheet.get(split[0]) != null ? sheet.get(split[0]) : 0;
        } else {
            left = Integer.parseInt(split[0]);
        }
        if(split[1].charAt(0) >= 'A' && split[1].charAt(1) <= 'Z') {
            right = sheet.get(split[1]) != null ? sheet.get(split[1]) : 0;
        } else {
            right = Integer.parseInt(split[1]);
        }
        return left + right;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
