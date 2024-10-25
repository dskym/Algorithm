class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        String temp = ".";
        for(int i=0;i<folder.length;++i) {
            if(isSubFolder(temp, folder[i])) {
                continue;
            }
            result.add(folder[i]);
            temp = folder[i];
        }
        return result;
    }

    private boolean isSubFolder(String parent, String child) {
        String[] parentList = parent.split("/");
        String[] childList = child.split("/");

        for(int i=0;i<parentList.length;++i) {
            if(parentList[i].equals(childList[i]) == false) {
                return false;
            }
        }

        return true;
    }
}
