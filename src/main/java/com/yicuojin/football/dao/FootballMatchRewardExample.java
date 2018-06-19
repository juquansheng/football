package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FootballMatchRewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballMatchRewardExample() {
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

        public Criteria andMatchidIsNull() {
            addCriterion("MatchId is null");
            return (Criteria) this;
        }

        public Criteria andMatchidIsNotNull() {
            addCriterion("MatchId is not null");
            return (Criteria) this;
        }

        public Criteria andMatchidEqualTo(Integer value) {
            addCriterion("MatchId =", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotEqualTo(Integer value) {
            addCriterion("MatchId <>", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThan(Integer value) {
            addCriterion("MatchId >", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MatchId >=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThan(Integer value) {
            addCriterion("MatchId <", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidLessThanOrEqualTo(Integer value) {
            addCriterion("MatchId <=", value, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidIn(List<Integer> values) {
            addCriterion("MatchId in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotIn(List<Integer> values) {
            addCriterion("MatchId not in", values, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidBetween(Integer value1, Integer value2) {
            addCriterion("MatchId between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andMatchidNotBetween(Integer value1, Integer value2) {
            addCriterion("MatchId not between", value1, value2, "matchid");
            return (Criteria) this;
        }

        public Criteria andAacountIsNull() {
            addCriterion("Aacount is null");
            return (Criteria) this;
        }

        public Criteria andAacountIsNotNull() {
            addCriterion("Aacount is not null");
            return (Criteria) this;
        }

        public Criteria andAacountEqualTo(BigDecimal value) {
            addCriterion("Aacount =", value, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountNotEqualTo(BigDecimal value) {
            addCriterion("Aacount <>", value, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountGreaterThan(BigDecimal value) {
            addCriterion("Aacount >", value, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Aacount >=", value, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountLessThan(BigDecimal value) {
            addCriterion("Aacount <", value, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Aacount <=", value, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountIn(List<BigDecimal> values) {
            addCriterion("Aacount in", values, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountNotIn(List<BigDecimal> values) {
            addCriterion("Aacount not in", values, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Aacount between", value1, value2, "aacount");
            return (Criteria) this;
        }

        public Criteria andAacountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Aacount not between", value1, value2, "aacount");
            return (Criteria) this;
        }

        public Criteria andBacountIsNull() {
            addCriterion("Bacount is null");
            return (Criteria) this;
        }

        public Criteria andBacountIsNotNull() {
            addCriterion("Bacount is not null");
            return (Criteria) this;
        }

        public Criteria andBacountEqualTo(BigDecimal value) {
            addCriterion("Bacount =", value, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountNotEqualTo(BigDecimal value) {
            addCriterion("Bacount <>", value, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountGreaterThan(BigDecimal value) {
            addCriterion("Bacount >", value, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Bacount >=", value, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountLessThan(BigDecimal value) {
            addCriterion("Bacount <", value, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Bacount <=", value, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountIn(List<BigDecimal> values) {
            addCriterion("Bacount in", values, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountNotIn(List<BigDecimal> values) {
            addCriterion("Bacount not in", values, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Bacount between", value1, value2, "bacount");
            return (Criteria) this;
        }

        public Criteria andBacountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Bacount not between", value1, value2, "bacount");
            return (Criteria) this;
        }

        public Criteria andCacountIsNull() {
            addCriterion("Cacount is null");
            return (Criteria) this;
        }

        public Criteria andCacountIsNotNull() {
            addCriterion("Cacount is not null");
            return (Criteria) this;
        }

        public Criteria andCacountEqualTo(BigDecimal value) {
            addCriterion("Cacount =", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountNotEqualTo(BigDecimal value) {
            addCriterion("Cacount <>", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountGreaterThan(BigDecimal value) {
            addCriterion("Cacount >", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Cacount >=", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountLessThan(BigDecimal value) {
            addCriterion("Cacount <", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Cacount <=", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountIn(List<BigDecimal> values) {
            addCriterion("Cacount in", values, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountNotIn(List<BigDecimal> values) {
            addCriterion("Cacount not in", values, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Cacount between", value1, value2, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Cacount not between", value1, value2, "cacount");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("Reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("Reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(BigDecimal value) {
            addCriterion("Reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(BigDecimal value) {
            addCriterion("Reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(BigDecimal value) {
            addCriterion("Reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(BigDecimal value) {
            addCriterion("Reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<BigDecimal> values) {
            addCriterion("Reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<BigDecimal> values) {
            addCriterion("Reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Reward not between", value1, value2, "reward");
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