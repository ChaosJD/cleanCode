package com.odde;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }


    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            appendOrderToStringbuffer(sb, i);
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    public void appendOrderToStringbuffer(StringBuffer sb, int i) {
        Order order = orders.getOrder(i);
        sb.append("{");
        appendKeyValueToStringbuffer(sb, "id", "" +order.getOrderId());
        sb.append(", ");
        sb.append("\"products\": [");
        for (int j = 0; j < order.getProductsCount(); j++) {
            Product product = order.getProduct(j);

            sb.append("{");
            appendKeyValueToStringbuffer(sb, "code", "" +product.getCode());
            sb.append("\", ");
            appendKeyValueToStringbuffer(sb, "color", "" +getColorFor(product));
            sb.append("\", ");

            if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
                appendKeyValueToStringbuffer(sb, "size", "" +getSizeFor(product));
                sb.append("\", ");
            }

            appendKeyValueToStringbuffer(sb, "price", "" +product.getPrice());

            sb.append(", ");
            appendKeyValueToStringbuffer(sb, "currency", "" +product.getCurrency());
            sb.append("\"}, ");
        }

        if (order.getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        sb.append("}, ");
    }

    public void appendKeyValueToStringbuffer(StringBuffer sb, String key, String value) {
        sb.append('"');
        sb.append(key);
        sb.append('"');
        sb.append(':');
        sb.append('"');
        sb.append(value);
        sb.append('"');

    }

    private String getSizeFor(Product product) {
        switch (product.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor(Product product) {
        switch (product.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }
}