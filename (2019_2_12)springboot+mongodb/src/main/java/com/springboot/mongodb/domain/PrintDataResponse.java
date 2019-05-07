package com.springboot.mongodb.domain;

import java.util.List;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class PrintDataResponse {

    /**
     * data : {"_dataFrom":"waybill","cpCode":"POSTB","needEncrypt":false,"packageInfo":{"id":"4444","items":[{"count":2,"name":"花语田园-薏仁透肌修复露"}],"volume":0,"weight":0},"parent":false,"recipient":{"address":{"city":"武汉","detail":"关山大道","district":"洪山","province":"湖北省"},"mobile":"12312312212","name":"cc","phone":""},"routingInfo":{"consolidation":{"name":"170鄂A"},"origin":{"code":"POSTB"},"receiveBranch":{"code":"43007912"},"routeCode":"08洪山 ","sortation":{"name":"洪山07-"},"startCenter":{},"terminalCenter":{}},"sender":{"address":{"city":"广州市","detail":"广东省广州市花都区","district":"花都区","province":"广东省"},"mobile":"02029836840","name":"JXSG","phone":"02029836840"},"shippingOption":{"code":"STANDARD_EXPRESS","title":"标准快递"},"waybillCode":"9895120116664"}
     * signature : MD:Yr6/2XrMfhUs2tSLmrB/aA==
     * templateURL : http://cloudprint.cainiao.com/template/standard/801/114
     */

    private Data data;
    private String signature;
    private String templateURL;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTemplateURL() {
        return templateURL;
    }

    public void setTemplateURL(String templateURL) {
        this.templateURL = templateURL;
    }

    @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        /**
         * _dataFrom : waybill
         * cpCode : POSTB
         * needEncrypt : false
         * packageInfo : {"id":"4444","items":[{"count":2,"name":"花语田园-薏仁透肌修复露"}],"volume":0,"weight":0}
         * parent : false
         * recipient : {"address":{"city":"武汉","detail":"关山大道","district":"洪山","province":"湖北省"},"mobile":"12312312212","name":"cc","phone":""}
         * routingInfo : {"consolidation":{"name":"170鄂A"},"origin":{"code":"POSTB"},"receiveBranch":{"code":"43007912"},"routeCode":"08洪山 ","sortation":{"name":"洪山07-"},"startCenter":{},"terminalCenter":{}}
         * sender : {"address":{"city":"广州市","detail":"广东省广州市花都区","district":"花都区","province":"广东省"},"mobile":"02029836840","name":"JXSG","phone":"02029836840"}
         * shippingOption : {"code":"STANDARD_EXPRESS","title":"标准快递"}
         * waybillCode : 9895120116664
         */

        private String _dataFrom;
        private String cpCode;
        private boolean needEncrypt;
        private PackageInfo packageInfo;
        private boolean parent;
        private Recipient recipient;
        private RoutingInfo routingInfo;
        private Sender sender;
        private ShippingOption shippingOption;
        private String waybillCode;

        public String get_dataFrom() {
            return _dataFrom;
        }

        public void set_dataFrom(String _dataFrom) {
            this._dataFrom = _dataFrom;
        }

        public String getCpCode() {
            return cpCode;
        }

        public void setCpCode(String cpCode) {
            this.cpCode = cpCode;
        }

        public boolean isNeedEncrypt() {
            return needEncrypt;
        }

        public void setNeedEncrypt(boolean needEncrypt) {
            this.needEncrypt = needEncrypt;
        }

        public PackageInfo getPackageInfo() {
            return packageInfo;
        }

        public void setPackageInfo(PackageInfo packageInfo) {
            this.packageInfo = packageInfo;
        }

        public boolean isParent() {
            return parent;
        }

        public void setParent(boolean parent) {
            this.parent = parent;
        }

        public Recipient getRecipient() {
            return recipient;
        }

        public void setRecipient(Recipient recipient) {
            this.recipient = recipient;
        }

        public RoutingInfo getRoutingInfo() {
            return routingInfo;
        }

        public void setRoutingInfo(RoutingInfo routingInfo) {
            this.routingInfo = routingInfo;
        }

        public Sender getSender() {
            return sender;
        }

        public void setSender(Sender sender) {
            this.sender = sender;
        }

        public ShippingOption getShippingOption() {
            return shippingOption;
        }

        public void setShippingOption(ShippingOption shippingOption) {
            this.shippingOption = shippingOption;
        }

        public String getWaybillCode() {
            return waybillCode;
        }

        public void setWaybillCode(String waybillCode) {
            this.waybillCode = waybillCode;
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class PackageInfo {
            /**
             * id : 4444
             * items : [{"count":2,"name":"花语田园-薏仁透肌修复露"}]
             * volume : 0
             * weight : 0
             */

            private String id;
            private int volume;
            private int weight;
            private List<Items> items;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getVolume() {
                return volume;
            }

            public void setVolume(int volume) {
                this.volume = volume;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public List<Items> getItems() {
                return items;
            }

            public void setItems(List<Items> items) {
                this.items = items;
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class Items {
                /**
                 * count : 2
                 * name : 花语田园-薏仁透肌修复露
                 */

                private int count;
                private String name;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class Recipient {
            /**
             * address : {"city":"武汉","detail":"关山大道","district":"洪山","province":"湖北省"}
             * mobile : 12312312212
             * name : cc
             * phone :
             */

            private Address address;
            private String mobile;
            private String name;
            private String phone;

            public Address getAddress() {
                return address;
            }

            public void setAddress(Address address) {
                this.address = address;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class Address {
                /**
                 * city : 武汉
                 * detail : 关山大道
                 * district : 洪山
                 * province : 湖北省
                 */

                private String city;
                private String detail;
                private String district;
                private String province;

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }
            }
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class RoutingInfo {
            /**
             * consolidation : {"name":"170鄂A"}
             * origin : {"code":"POSTB"}
             * receiveBranch : {"code":"43007912"}
             * routeCode : 08洪山
             * sortation : {"name":"洪山07-"}
             * startCenter : {}
             * terminalCenter : {}
             */

            private Consolidation consolidation;
            private Origin origin;
            private ReceiveBranch receiveBranch;
            private String routeCode;
            private Sortation sortation;
            private StartCenter startCenter;
            private TerminalCenter terminalCenter;

            public Consolidation getConsolidation() {
                return consolidation;
            }

            public void setConsolidation(Consolidation consolidation) {
                this.consolidation = consolidation;
            }

            public Origin getOrigin() {
                return origin;
            }

            public void setOrigin(Origin origin) {
                this.origin = origin;
            }

            public ReceiveBranch getReceiveBranch() {
                return receiveBranch;
            }

            public void setReceiveBranch(ReceiveBranch receiveBranch) {
                this.receiveBranch = receiveBranch;
            }

            public String getRouteCode() {
                return routeCode;
            }

            public void setRouteCode(String routeCode) {
                this.routeCode = routeCode;
            }

            public Sortation getSortation() {
                return sortation;
            }

            public void setSortation(Sortation sortation) {
                this.sortation = sortation;
            }

            public StartCenter getStartCenter() {
                return startCenter;
            }

            public void setStartCenter(StartCenter startCenter) {
                this.startCenter = startCenter;
            }

            public TerminalCenter getTerminalCenter() {
                return terminalCenter;
            }

            public void setTerminalCenter(TerminalCenter terminalCenter) {
                this.terminalCenter = terminalCenter;
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class Consolidation {
                /**
                 * name : 170鄂A
                 */

                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class Origin {
                /**
                 * code : POSTB
                 */

                private String code;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveBranch {
                /**
                 * code : 43007912
                 */

                private String code;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class Sortation {
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class StartCenter {
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class TerminalCenter {
            }
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class Sender {
            /**
             * address : {"city":"广州市","detail":"广东省广州市花都区","district":"花都区","province":"广东省"}
             * mobile : 02029836840
             * name : JXSG
             * phone : 02029836840
             */

            private AddressX address;
            private String mobile;
            private String name;
            private String phone;

            public AddressX getAddress() {
                return address;
            }

            public void setAddress(AddressX address) {
                this.address = address;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
            public static class AddressX {
                /**
                 * city : 广州市
                 * detail : 广东省广州市花都区
                 * district : 花都区
                 * province : 广东省
                 */

                private String city;
                private String detail;
                private String district;
                private String province;

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }
            }
        }

        @com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
        public static class ShippingOption {
            /**
             * code : STANDARD_EXPRESS
             * title : 标准快递
             */

            private String code;
            private String title;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
