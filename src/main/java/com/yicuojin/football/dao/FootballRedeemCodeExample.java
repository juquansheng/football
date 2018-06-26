package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FootballRedeemCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballRedeemCodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("UserId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("UserId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("UserId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("UserId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("UserId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("UserId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("UserId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("UserId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("UserId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseidIsNull() {
            addCriterion("UseId is null");
            return (Criteria) this;
        }

        public Criteria andUseidIsNotNull() {
            addCriterion("UseId is not null");
            return (Criteria) this;
        }

        public Criteria andUseidEqualTo(Integer value) {
            addCriterion("UseId =", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotEqualTo(Integer value) {
            addCriterion("UseId <>", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThan(Integer value) {
            addCriterion("UseId >", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UseId >=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThan(Integer value) {
            addCriterion("UseId <", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThanOrEqualTo(Integer value) {
            addCriterion("UseId <=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidIn(List<Integer> values) {
            addCriterion("UseId in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotIn(List<Integer> values) {
            addCriterion("UseId not in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidBetween(Integer value1, Integer value2) {
            addCriterion("UseId between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotBetween(Integer value1, Integer value2) {
            addCriterion("UseId not between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidIsNull() {
            addCriterion("RedeemGoodsId is null");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidIsNotNull() {
            addCriterion("RedeemGoodsId is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidEqualTo(Integer value) {
            addCriterion("RedeemGoodsId =", value, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidNotEqualTo(Integer value) {
            addCriterion("RedeemGoodsId <>", value, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidGreaterThan(Integer value) {
            addCriterion("RedeemGoodsId >", value, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RedeemGoodsId >=", value, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidLessThan(Integer value) {
            addCriterion("RedeemGoodsId <", value, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("RedeemGoodsId <=", value, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidIn(List<Integer> values) {
            addCriterion("RedeemGoodsId in", values, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidNotIn(List<Integer> values) {
            addCriterion("RedeemGoodsId not in", values, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidBetween(Integer value1, Integer value2) {
            addCriterion("RedeemGoodsId between", value1, value2, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemgoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("RedeemGoodsId not between", value1, value2, "redeemgoodsid");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeIsNull() {
            addCriterion("RedeemCode is null");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeIsNotNull() {
            addCriterion("RedeemCode is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeEqualTo(String value) {
            addCriterion("RedeemCode =", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeNotEqualTo(String value) {
            addCriterion("RedeemCode <>", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeGreaterThan(String value) {
            addCriterion("RedeemCode >", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RedeemCode >=", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeLessThan(String value) {
            addCriterion("RedeemCode <", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeLessThanOrEqualTo(String value) {
            addCriterion("RedeemCode <=", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeLike(String value) {
            addCriterion("RedeemCode like", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeNotLike(String value) {
            addCriterion("RedeemCode not like", value, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeIn(List<String> values) {
            addCriterion("RedeemCode in", values, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeNotIn(List<String> values) {
            addCriterion("RedeemCode not in", values, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeBetween(String value1, String value2) {
            addCriterion("RedeemCode between", value1, value2, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andRedeemcodeNotBetween(String value1, String value2) {
            addCriterion("RedeemCode not between", value1, value2, "redeemcode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAppaccountIsNull() {
            addCriterion("AppAccount is null");
            return (Criteria) this;
        }

        public Criteria andAppaccountIsNotNull() {
            addCriterion("AppAccount is not null");
            return (Criteria) this;
        }

        public Criteria andAppaccountEqualTo(BigDecimal value) {
            addCriterion("AppAccount =", value, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountNotEqualTo(BigDecimal value) {
            addCriterion("AppAccount <>", value, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountGreaterThan(BigDecimal value) {
            addCriterion("AppAccount >", value, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AppAccount >=", value, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountLessThan(BigDecimal value) {
            addCriterion("AppAccount <", value, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AppAccount <=", value, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountIn(List<BigDecimal> values) {
            addCriterion("AppAccount in", values, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountNotIn(List<BigDecimal> values) {
            addCriterion("AppAccount not in", values, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AppAccount between", value1, value2, "appaccount");
            return (Criteria) this;
        }

        public Criteria andAppaccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AppAccount not between", value1, value2, "appaccount");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrIsNull() {
            addCriterion("RedeemDescr is null");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrIsNotNull() {
            addCriterion("RedeemDescr is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrEqualTo(String value) {
            addCriterion("RedeemDescr =", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrNotEqualTo(String value) {
            addCriterion("RedeemDescr <>", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrGreaterThan(String value) {
            addCriterion("RedeemDescr >", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrGreaterThanOrEqualTo(String value) {
            addCriterion("RedeemDescr >=", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrLessThan(String value) {
            addCriterion("RedeemDescr <", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrLessThanOrEqualTo(String value) {
            addCriterion("RedeemDescr <=", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrLike(String value) {
            addCriterion("RedeemDescr like", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrNotLike(String value) {
            addCriterion("RedeemDescr not like", value, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrIn(List<String> values) {
            addCriterion("RedeemDescr in", values, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrNotIn(List<String> values) {
            addCriterion("RedeemDescr not in", values, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrBetween(String value1, String value2) {
            addCriterion("RedeemDescr between", value1, value2, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andRedeemdescrNotBetween(String value1, String value2) {
            addCriterion("RedeemDescr not between", value1, value2, "redeemdescr");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNull() {
            addCriterion("UseTime is null");
            return (Criteria) this;
        }

        public Criteria andUsetimeIsNotNull() {
            addCriterion("UseTime is not null");
            return (Criteria) this;
        }

        public Criteria andUsetimeEqualTo(Date value) {
            addCriterion("UseTime =", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotEqualTo(Date value) {
            addCriterion("UseTime <>", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThan(Date value) {
            addCriterion("UseTime >", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UseTime >=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThan(Date value) {
            addCriterion("UseTime <", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeLessThanOrEqualTo(Date value) {
            addCriterion("UseTime <=", value, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeIn(List<Date> values) {
            addCriterion("UseTime in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotIn(List<Date> values) {
            addCriterion("UseTime not in", values, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeBetween(Date value1, Date value2) {
            addCriterion("UseTime between", value1, value2, "usetime");
            return (Criteria) this;
        }

        public Criteria andUsetimeNotBetween(Date value1, Date value2) {
            addCriterion("UseTime not between", value1, value2, "usetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}