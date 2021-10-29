class Solution {
    public String simplifyPath(String path) {
        
        LinkedList<String> pathList = new LinkedList<>();
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (".".equals(part) || "".equals(part))
                continue;
            if ("..".equals(part)) {
                pathList.pollLast();
                    
            }
            else pathList.add(part);
        }
        
        return "/" + String.join("/", pathList);
    }
}