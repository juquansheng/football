package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FootballGuessRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FootballGuessRecordExample() {
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

        public Criteria andUserguessIsNull() {
            addCriterion("UserGuess is null");
            return (Criteria) this;
        }

        public Criteria andUserguessIsNotNull() {
            addCriterion("UserGuess is not null");
            return (Criteria) this;
        }

        public Criteria andUserguessEqualTo(Integer value) {
            addCriterion("UserGuess =", value, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessNotEqualTo(Integer value) {
            addCriterion("UserGuess <>", value, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessGreaterThan(Integer value) {
            addCriterion("UserGuess >", value, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserGuess >=", value, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessLessThan(Integer value) {
            addCriterion("UserGuess <", value, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessLessThanOrEqualTo(Integer value) {
            addCriterion("UserGuess <=", value, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessIn(List<Integer> values) {
            addCriterion("UserGuess in", values, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessNotIn(List<Integer> values) {
            addCriterion("UserGuess not in", values, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessBetween(Integer value1, Integer value2) {
            addCriterion("UserGuess between", value1, value2, "userguess");
            return (Criteria) this;
        }

        public Criteria andUserguessNotBetween(Integer value1, Integer value2) {
            addCriterion("UserGuess not between", value1, value2, "userguess");
            return (Criteria) this;
        }

        public Criteria andMatchresultIsNull() {
            addCriterion("MatchResult is null");
            return (Criteria) this;
        }

        public Criteria andMatchresultIsNotNull() {
            addCriterion("MatchResult is not null");
            return (Criteria) this;
        }

        public Criteria andMatchresultEqualTo(Integer value) {
            addCriterion("MatchResult =", value, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultNotEqualTo(Integer value) {
            addCriterion("MatchResult <>", value, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultGreaterThan(Integer value) {
            addCriterion("MatchResult >", value, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("MatchResult >=", value, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultLessThan(Integer value) {
            addCriterion("MatchResult <", value, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultLessThanOrEqualTo(Integer value) {
            addCriterion("MatchResult <=", value, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultIn(List<Integer> values) {
            addCriterion("MatchResult in", values, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultNotIn(List<Integer> values) {
            addCriterion("MatchResult not in", values, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultBetween(Integer value1, Integer value2) {
            addCriterion("MatchResult between", value1, value2, "matchresult");
            return (Criteria) this;
        }

        public Criteria andMatchresultNotBetween(Integer value1, Integer value2) {
            addCriterion("MatchResult not between", value1, value2, "matchresult");
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

        public Criteria andBetsIsNull() {
            addCriterion("Bets is null");
            return (Criteria) this;
        }

        public Criteria andBetsIsNotNull() {
            addCriterion("Bets is not null");
            return (Criteria) this;
        }

        public Criteria andBetsEqualTo(BigDecimal value) {
            addCriterion("Bets =", value, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsNotEqualTo(BigDecimal value) {
            addCriterion("Bets <>", value, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsGreaterThan(BigDecimal value) {
            addCriterion("Bets >", value, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Bets >=", value, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsLessThan(BigDecimal value) {
            addCriterion("Bets <", value, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Bets <=", value, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsIn(List<BigDecimal> values) {
            addCriterion("Bets in", values, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsNotIn(List<BigDecimal> values) {
            addCriterion("Bets not in", values, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Bets between", value1, value2, "bets");
            return (Criteria) this;
        }

        public Criteria andBetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Bets not between", value1, value2, "bets");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
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