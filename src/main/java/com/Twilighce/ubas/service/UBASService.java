
package com.Twilighce.ubas.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UBASService {

  public interface Iface {

    public Map<String,Double> queryDayKPI(String beginDate, String endDate) throws org.apache.thrift.TException;

    public Map<Double,Double> queryHourKPI(String beginDate, String endDate) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void queryDayKPI(String beginDate, String endDate, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

    public void queryHourKPI(String beginDate, String endDate, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public Map<String,Double> queryDayKPI(String beginDate, String endDate) throws org.apache.thrift.TException
    {
      send_queryDayKPI(beginDate, endDate);
      return recv_queryDayKPI();
    }

    public void send_queryDayKPI(String beginDate, String endDate) throws org.apache.thrift.TException
    {
      queryDayKPI_args args = new queryDayKPI_args();
      args.setBeginDate(beginDate);
      args.setEndDate(endDate);
      sendBase("queryDayKPI", args);
    }

    public Map<String,Double> recv_queryDayKPI() throws org.apache.thrift.TException
    {
      queryDayKPI_result result = new queryDayKPI_result();
      receiveBase(result, "queryDayKPI");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "queryDayKPI failed: unknown result");
    }

    public Map<Double,Double> queryHourKPI(String beginDate, String endDate) throws org.apache.thrift.TException
    {
      send_queryHourKPI(beginDate, endDate);
      return recv_queryHourKPI();
    }

    public void send_queryHourKPI(String beginDate, String endDate) throws org.apache.thrift.TException
    {
      queryHourKPI_args args = new queryHourKPI_args();
      args.setBeginDate(beginDate);
      args.setEndDate(endDate);
      sendBase("queryHourKPI", args);
    }

    public Map<Double,Double> recv_queryHourKPI() throws org.apache.thrift.TException
    {
      queryHourKPI_result result = new queryHourKPI_result();
      receiveBase(result, "queryHourKPI");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "queryHourKPI failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void queryDayKPI(String beginDate, String endDate, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
      checkReady();
      queryDayKPI_call method_call = new queryDayKPI_call(beginDate, endDate, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class queryDayKPI_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String beginDate;
      private String endDate;
      public queryDayKPI_call(String beginDate, String endDate, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.beginDate = beginDate;
        this.endDate = endDate;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("queryDayKPI", org.apache.thrift.protocol.TMessageType.CALL, 0));
        queryDayKPI_args args = new queryDayKPI_args();
        args.setBeginDate(beginDate);
        args.setEndDate(endDate);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public Map<String,Double> getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_queryDayKPI();
      }
    }

    public void queryHourKPI(String beginDate, String endDate, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
      checkReady();
      queryHourKPI_call method_call = new queryHourKPI_call(beginDate, endDate, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class queryHourKPI_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String beginDate;
      private String endDate;
      public queryHourKPI_call(String beginDate, String endDate, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.beginDate = beginDate;
        this.endDate = endDate;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("queryHourKPI", org.apache.thrift.protocol.TMessageType.CALL, 0));
        queryHourKPI_args args = new queryHourKPI_args();
        args.setBeginDate(beginDate);
        args.setEndDate(endDate);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public Map<Double,Double> getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_queryHourKPI();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("queryDayKPI", new queryDayKPI());
      processMap.put("queryHourKPI", new queryHourKPI());
      return processMap;
    }

    public static class queryDayKPI<I extends Iface> extends org.apache.thrift.ProcessFunction<I, queryDayKPI_args> {
      public queryDayKPI() {
        super("queryDayKPI");
      }

      public queryDayKPI_args getEmptyArgsInstance() {
        return new queryDayKPI_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public queryDayKPI_result getResult(I iface, queryDayKPI_args args) throws org.apache.thrift.TException {
        queryDayKPI_result result = new queryDayKPI_result();
        result.success = iface.queryDayKPI(args.beginDate, args.endDate);
        return result;
      }
    }

    public static class queryHourKPI<I extends Iface> extends org.apache.thrift.ProcessFunction<I, queryHourKPI_args> {
      public queryHourKPI() {
        super("queryHourKPI");
      }

      public queryHourKPI_args getEmptyArgsInstance() {
        return new queryHourKPI_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public queryHourKPI_result getResult(I iface, queryHourKPI_args args) throws org.apache.thrift.TException {
        queryHourKPI_result result = new queryHourKPI_result();
        result.success = iface.queryHourKPI(args.beginDate, args.endDate);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("queryDayKPI", new queryDayKPI());
      processMap.put("queryHourKPI", new queryHourKPI());
      return processMap;
    }

    public static class queryDayKPI<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, queryDayKPI_args, Map<String,Double>> {
      public queryDayKPI() {
        super("queryDayKPI");
      }

      public queryDayKPI_args getEmptyArgsInstance() {
        return new queryDayKPI_args();
      }

      public AsyncMethodCallback<Map<String,Double>> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<Map<String,Double>>() { 
          public void onComplete(Map<String,Double> o) {
            queryDayKPI_result result = new queryDayKPI_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            queryDayKPI_result result = new queryDayKPI_result();
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, queryDayKPI_args args, org.apache.thrift.async.AsyncMethodCallback<Map<String,Double>> resultHandler) throws TException {
        iface.queryDayKPI(args.beginDate, args.endDate,resultHandler);
      }
    }

    public static class queryHourKPI<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, queryHourKPI_args, Map<Double,Double>> {
      public queryHourKPI() {
        super("queryHourKPI");
      }

      public queryHourKPI_args getEmptyArgsInstance() {
        return new queryHourKPI_args();
      }

      public AsyncMethodCallback<Map<Double,Double>> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<Map<Double,Double>>() { 
          public void onComplete(Map<Double,Double> o) {
            queryHourKPI_result result = new queryHourKPI_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            queryHourKPI_result result = new queryHourKPI_result();
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, queryHourKPI_args args, org.apache.thrift.async.AsyncMethodCallback<Map<Double,Double>> resultHandler) throws TException {
        iface.queryHourKPI(args.beginDate, args.endDate,resultHandler);
      }
    }

  }

  public static class queryDayKPI_args implements org.apache.thrift.TBase<queryDayKPI_args, queryDayKPI_args._Fields>, java.io.Serializable, Cloneable, Comparable<queryDayKPI_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("queryDayKPI_args");

    private static final org.apache.thrift.protocol.TField BEGIN_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("beginDate", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField END_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("endDate", org.apache.thrift.protocol.TType.STRING, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new queryDayKPI_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new queryDayKPI_argsTupleSchemeFactory());
    }

    public String beginDate; // required
    public String endDate; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      BEGIN_DATE((short)1, "beginDate"),
      END_DATE((short)2, "endDate");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // BEGIN_DATE
            return BEGIN_DATE;
          case 2: // END_DATE
            return END_DATE;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.BEGIN_DATE, new org.apache.thrift.meta_data.FieldMetaData("beginDate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.END_DATE, new org.apache.thrift.meta_data.FieldMetaData("endDate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryDayKPI_args.class, metaDataMap);
    }

    public queryDayKPI_args() {
    }

    public queryDayKPI_args(
      String beginDate,
      String endDate)
    {
      this();
      this.beginDate = beginDate;
      this.endDate = endDate;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public queryDayKPI_args(queryDayKPI_args other) {
      if (other.isSetBeginDate()) {
        this.beginDate = other.beginDate;
      }
      if (other.isSetEndDate()) {
        this.endDate = other.endDate;
      }
    }

    public queryDayKPI_args deepCopy() {
      return new queryDayKPI_args(this);
    }

    @Override
    public void clear() {
      this.beginDate = null;
      this.endDate = null;
    }

    public String getBeginDate() {
      return this.beginDate;
    }

    public queryDayKPI_args setBeginDate(String beginDate) {
      this.beginDate = beginDate;
      return this;
    }

    public void unsetBeginDate() {
      this.beginDate = null;
    }

    /** Returns true if field beginDate is set (has been assigned a value) and false otherwise */
    public boolean isSetBeginDate() {
      return this.beginDate != null;
    }

    public void setBeginDateIsSet(boolean value) {
      if (!value) {
        this.beginDate = null;
      }
    }

    public String getEndDate() {
      return this.endDate;
    }

    public queryDayKPI_args setEndDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    public void unsetEndDate() {
      this.endDate = null;
    }

    /** Returns true if field endDate is set (has been assigned a value) and false otherwise */
    public boolean isSetEndDate() {
      return this.endDate != null;
    }

    public void setEndDateIsSet(boolean value) {
      if (!value) {
        this.endDate = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case BEGIN_DATE:
        if (value == null) {
          unsetBeginDate();
        } else {
          setBeginDate((String)value);
        }
        break;

      case END_DATE:
        if (value == null) {
          unsetEndDate();
        } else {
          setEndDate((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case BEGIN_DATE:
        return getBeginDate();

      case END_DATE:
        return getEndDate();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case BEGIN_DATE:
        return isSetBeginDate();
      case END_DATE:
        return isSetEndDate();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof queryDayKPI_args)
        return this.equals((queryDayKPI_args)that);
      return false;
    }

    public boolean equals(queryDayKPI_args that) {
      if (that == null)
        return false;

      boolean this_present_beginDate = true && this.isSetBeginDate();
      boolean that_present_beginDate = true && that.isSetBeginDate();
      if (this_present_beginDate || that_present_beginDate) {
        if (!(this_present_beginDate && that_present_beginDate))
          return false;
        if (!this.beginDate.equals(that.beginDate))
          return false;
      }

      boolean this_present_endDate = true && this.isSetEndDate();
      boolean that_present_endDate = true && that.isSetEndDate();
      if (this_present_endDate || that_present_endDate) {
        if (!(this_present_endDate && that_present_endDate))
          return false;
        if (!this.endDate.equals(that.endDate))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    @Override
    public int compareTo(queryDayKPI_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetBeginDate()).compareTo(other.isSetBeginDate());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetBeginDate()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.beginDate, other.beginDate);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetEndDate()).compareTo(other.isSetEndDate());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetEndDate()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endDate, other.endDate);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("queryDayKPI_args(");
      boolean first = true;

      sb.append("beginDate:");
      if (this.beginDate == null) {
        sb.append("null");
      } else {
        sb.append(this.beginDate);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("endDate:");
      if (this.endDate == null) {
        sb.append("null");
      } else {
        sb.append(this.endDate);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class queryDayKPI_argsStandardSchemeFactory implements SchemeFactory {
      public queryDayKPI_argsStandardScheme getScheme() {
        return new queryDayKPI_argsStandardScheme();
      }
    }

    private static class queryDayKPI_argsStandardScheme extends StandardScheme<queryDayKPI_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, queryDayKPI_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // BEGIN_DATE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.beginDate = iprot.readString();
                struct.setBeginDateIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // END_DATE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.endDate = iprot.readString();
                struct.setEndDateIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, queryDayKPI_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.beginDate != null) {
          oprot.writeFieldBegin(BEGIN_DATE_FIELD_DESC);
          oprot.writeString(struct.beginDate);
          oprot.writeFieldEnd();
        }
        if (struct.endDate != null) {
          oprot.writeFieldBegin(END_DATE_FIELD_DESC);
          oprot.writeString(struct.endDate);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class queryDayKPI_argsTupleSchemeFactory implements SchemeFactory {
      public queryDayKPI_argsTupleScheme getScheme() {
        return new queryDayKPI_argsTupleScheme();
      }
    }

    private static class queryDayKPI_argsTupleScheme extends TupleScheme<queryDayKPI_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, queryDayKPI_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetBeginDate()) {
          optionals.set(0);
        }
        if (struct.isSetEndDate()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetBeginDate()) {
          oprot.writeString(struct.beginDate);
        }
        if (struct.isSetEndDate()) {
          oprot.writeString(struct.endDate);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, queryDayKPI_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.beginDate = iprot.readString();
          struct.setBeginDateIsSet(true);
        }
        if (incoming.get(1)) {
          struct.endDate = iprot.readString();
          struct.setEndDateIsSet(true);
        }
      }
    }

  }

  public static class queryDayKPI_result implements org.apache.thrift.TBase<queryDayKPI_result, queryDayKPI_result._Fields>, java.io.Serializable, Cloneable, Comparable<queryDayKPI_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("queryDayKPI_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.MAP, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new queryDayKPI_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new queryDayKPI_resultTupleSchemeFactory());
    }

    public Map<String,Double> success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
              new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
              new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE))));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryDayKPI_result.class, metaDataMap);
    }

    public queryDayKPI_result() {
    }

    public queryDayKPI_result(
      Map<String,Double> success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public queryDayKPI_result(queryDayKPI_result other) {
      if (other.isSetSuccess()) {
        Map<String,Double> __this__success = new HashMap<String,Double>(other.success);
        this.success = __this__success;
      }
    }

    public queryDayKPI_result deepCopy() {
      return new queryDayKPI_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public int getSuccessSize() {
      return (this.success == null) ? 0 : this.success.size();
    }

    public void putToSuccess(String key, double val) {
      if (this.success == null) {
        this.success = new HashMap<String,Double>();
      }
      this.success.put(key, val);
    }

    public Map<String,Double> getSuccess() {
      return this.success;
    }

    public queryDayKPI_result setSuccess(Map<String,Double> success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Map<String,Double>)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof queryDayKPI_result)
        return this.equals((queryDayKPI_result)that);
      return false;
    }

    public boolean equals(queryDayKPI_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    @Override
    public int compareTo(queryDayKPI_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("queryDayKPI_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class queryDayKPI_resultStandardSchemeFactory implements SchemeFactory {
      public queryDayKPI_resultStandardScheme getScheme() {
        return new queryDayKPI_resultStandardScheme();
      }
    }

    private static class queryDayKPI_resultStandardScheme extends StandardScheme<queryDayKPI_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, queryDayKPI_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
                {
                  org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                  struct.success = new HashMap<String,Double>(2*_map0.size);
                  for (int _i1 = 0; _i1 < _map0.size; ++_i1)
                  {
                    String _key2;
                    double _val3;
                    _key2 = iprot.readString();
                    _val3 = iprot.readDouble();
                    struct.success.put(_key2, _val3);
                  }
                  iprot.readMapEnd();
                }
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, queryDayKPI_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.DOUBLE, struct.success.size()));
            for (Map.Entry<String, Double> _iter4 : struct.success.entrySet())
            {
              oprot.writeString(_iter4.getKey());
              oprot.writeDouble(_iter4.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class queryDayKPI_resultTupleSchemeFactory implements SchemeFactory {
      public queryDayKPI_resultTupleScheme getScheme() {
        return new queryDayKPI_resultTupleScheme();
      }
    }

    private static class queryDayKPI_resultTupleScheme extends TupleScheme<queryDayKPI_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, queryDayKPI_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          {
            oprot.writeI32(struct.success.size());
            for (Map.Entry<String, Double> _iter5 : struct.success.entrySet())
            {
              oprot.writeString(_iter5.getKey());
              oprot.writeDouble(_iter5.getValue());
            }
          }
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, queryDayKPI_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          {
            org.apache.thrift.protocol.TMap _map6 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.DOUBLE, iprot.readI32());
            struct.success = new HashMap<String,Double>(2*_map6.size);
            for (int _i7 = 0; _i7 < _map6.size; ++_i7)
            {
              String _key8;
              double _val9;
              _key8 = iprot.readString();
              _val9 = iprot.readDouble();
              struct.success.put(_key8, _val9);
            }
          }
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

  public static class queryHourKPI_args implements org.apache.thrift.TBase<queryHourKPI_args, queryHourKPI_args._Fields>, java.io.Serializable, Cloneable, Comparable<queryHourKPI_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("queryHourKPI_args");

    private static final org.apache.thrift.protocol.TField BEGIN_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("beginDate", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField END_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("endDate", org.apache.thrift.protocol.TType.STRING, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new queryHourKPI_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new queryHourKPI_argsTupleSchemeFactory());
    }

    public String beginDate; // required
    public String endDate; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      BEGIN_DATE((short)1, "beginDate"),
      END_DATE((short)2, "endDate");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // BEGIN_DATE
            return BEGIN_DATE;
          case 2: // END_DATE
            return END_DATE;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.BEGIN_DATE, new org.apache.thrift.meta_data.FieldMetaData("beginDate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.END_DATE, new org.apache.thrift.meta_data.FieldMetaData("endDate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryHourKPI_args.class, metaDataMap);
    }

    public queryHourKPI_args() {
    }

    public queryHourKPI_args(
      String beginDate,
      String endDate)
    {
      this();
      this.beginDate = beginDate;
      this.endDate = endDate;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public queryHourKPI_args(queryHourKPI_args other) {
      if (other.isSetBeginDate()) {
        this.beginDate = other.beginDate;
      }
      if (other.isSetEndDate()) {
        this.endDate = other.endDate;
      }
    }

    public queryHourKPI_args deepCopy() {
      return new queryHourKPI_args(this);
    }

    @Override
    public void clear() {
      this.beginDate = null;
      this.endDate = null;
    }

    public String getBeginDate() {
      return this.beginDate;
    }

    public queryHourKPI_args setBeginDate(String beginDate) {
      this.beginDate = beginDate;
      return this;
    }

    public void unsetBeginDate() {
      this.beginDate = null;
    }

    /** Returns true if field beginDate is set (has been assigned a value) and false otherwise */
    public boolean isSetBeginDate() {
      return this.beginDate != null;
    }

    public void setBeginDateIsSet(boolean value) {
      if (!value) {
        this.beginDate = null;
      }
    }

    public String getEndDate() {
      return this.endDate;
    }

    public queryHourKPI_args setEndDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    public void unsetEndDate() {
      this.endDate = null;
    }

    /** Returns true if field endDate is set (has been assigned a value) and false otherwise */
    public boolean isSetEndDate() {
      return this.endDate != null;
    }

    public void setEndDateIsSet(boolean value) {
      if (!value) {
        this.endDate = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case BEGIN_DATE:
        if (value == null) {
          unsetBeginDate();
        } else {
          setBeginDate((String)value);
        }
        break;

      case END_DATE:
        if (value == null) {
          unsetEndDate();
        } else {
          setEndDate((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case BEGIN_DATE:
        return getBeginDate();

      case END_DATE:
        return getEndDate();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case BEGIN_DATE:
        return isSetBeginDate();
      case END_DATE:
        return isSetEndDate();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof queryHourKPI_args)
        return this.equals((queryHourKPI_args)that);
      return false;
    }

    public boolean equals(queryHourKPI_args that) {
      if (that == null)
        return false;

      boolean this_present_beginDate = true && this.isSetBeginDate();
      boolean that_present_beginDate = true && that.isSetBeginDate();
      if (this_present_beginDate || that_present_beginDate) {
        if (!(this_present_beginDate && that_present_beginDate))
          return false;
        if (!this.beginDate.equals(that.beginDate))
          return false;
      }

      boolean this_present_endDate = true && this.isSetEndDate();
      boolean that_present_endDate = true && that.isSetEndDate();
      if (this_present_endDate || that_present_endDate) {
        if (!(this_present_endDate && that_present_endDate))
          return false;
        if (!this.endDate.equals(that.endDate))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    @Override
    public int compareTo(queryHourKPI_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetBeginDate()).compareTo(other.isSetBeginDate());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetBeginDate()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.beginDate, other.beginDate);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetEndDate()).compareTo(other.isSetEndDate());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetEndDate()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endDate, other.endDate);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("queryHourKPI_args(");
      boolean first = true;

      sb.append("beginDate:");
      if (this.beginDate == null) {
        sb.append("null");
      } else {
        sb.append(this.beginDate);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("endDate:");
      if (this.endDate == null) {
        sb.append("null");
      } else {
        sb.append(this.endDate);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class queryHourKPI_argsStandardSchemeFactory implements SchemeFactory {
      public queryHourKPI_argsStandardScheme getScheme() {
        return new queryHourKPI_argsStandardScheme();
      }
    }

    private static class queryHourKPI_argsStandardScheme extends StandardScheme<queryHourKPI_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, queryHourKPI_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // BEGIN_DATE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.beginDate = iprot.readString();
                struct.setBeginDateIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // END_DATE
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.endDate = iprot.readString();
                struct.setEndDateIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, queryHourKPI_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.beginDate != null) {
          oprot.writeFieldBegin(BEGIN_DATE_FIELD_DESC);
          oprot.writeString(struct.beginDate);
          oprot.writeFieldEnd();
        }
        if (struct.endDate != null) {
          oprot.writeFieldBegin(END_DATE_FIELD_DESC);
          oprot.writeString(struct.endDate);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class queryHourKPI_argsTupleSchemeFactory implements SchemeFactory {
      public queryHourKPI_argsTupleScheme getScheme() {
        return new queryHourKPI_argsTupleScheme();
      }
    }

    private static class queryHourKPI_argsTupleScheme extends TupleScheme<queryHourKPI_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, queryHourKPI_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetBeginDate()) {
          optionals.set(0);
        }
        if (struct.isSetEndDate()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetBeginDate()) {
          oprot.writeString(struct.beginDate);
        }
        if (struct.isSetEndDate()) {
          oprot.writeString(struct.endDate);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, queryHourKPI_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.beginDate = iprot.readString();
          struct.setBeginDateIsSet(true);
        }
        if (incoming.get(1)) {
          struct.endDate = iprot.readString();
          struct.setEndDateIsSet(true);
        }
      }
    }

  }

  public static class queryHourKPI_result implements org.apache.thrift.TBase<queryHourKPI_result, queryHourKPI_result._Fields>, java.io.Serializable, Cloneable, Comparable<queryHourKPI_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("queryHourKPI_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.MAP, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new queryHourKPI_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new queryHourKPI_resultTupleSchemeFactory());
    }

    public Map<Double,Double> success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
              new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE), 
              new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE))));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryHourKPI_result.class, metaDataMap);
    }

    public queryHourKPI_result() {
    }

    public queryHourKPI_result(
      Map<Double,Double> success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public queryHourKPI_result(queryHourKPI_result other) {
      if (other.isSetSuccess()) {
        Map<Double,Double> __this__success = new HashMap<Double,Double>(other.success);
        this.success = __this__success;
      }
    }

    public queryHourKPI_result deepCopy() {
      return new queryHourKPI_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public int getSuccessSize() {
      return (this.success == null) ? 0 : this.success.size();
    }

    public void putToSuccess(double key, double val) {
      if (this.success == null) {
        this.success = new HashMap<Double,Double>();
      }
      this.success.put(key, val);
    }

    public Map<Double,Double> getSuccess() {
      return this.success;
    }

    public queryHourKPI_result setSuccess(Map<Double,Double> success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Map<Double,Double>)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof queryHourKPI_result)
        return this.equals((queryHourKPI_result)that);
      return false;
    }

    public boolean equals(queryHourKPI_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    @Override
    public int compareTo(queryHourKPI_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("queryHourKPI_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class queryHourKPI_resultStandardSchemeFactory implements SchemeFactory {
      public queryHourKPI_resultStandardScheme getScheme() {
        return new queryHourKPI_resultStandardScheme();
      }
    }

    private static class queryHourKPI_resultStandardScheme extends StandardScheme<queryHourKPI_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, queryHourKPI_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
                {
                  org.apache.thrift.protocol.TMap _map10 = iprot.readMapBegin();
                  struct.success = new HashMap<Double,Double>(2*_map10.size);
                  for (int _i11 = 0; _i11 < _map10.size; ++_i11)
                  {
                    double _key12;
                    double _val13;
                    _key12 = iprot.readDouble();
                    _val13 = iprot.readDouble();
                    struct.success.put(_key12, _val13);
                  }
                  iprot.readMapEnd();
                }
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, queryHourKPI_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.DOUBLE, org.apache.thrift.protocol.TType.DOUBLE, struct.success.size()));
            for (Map.Entry<Double, Double> _iter14 : struct.success.entrySet())
            {
              oprot.writeDouble(_iter14.getKey());
              oprot.writeDouble(_iter14.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class queryHourKPI_resultTupleSchemeFactory implements SchemeFactory {
      public queryHourKPI_resultTupleScheme getScheme() {
        return new queryHourKPI_resultTupleScheme();
      }
    }

    private static class queryHourKPI_resultTupleScheme extends TupleScheme<queryHourKPI_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, queryHourKPI_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          {
            oprot.writeI32(struct.success.size());
            for (Map.Entry<Double, Double> _iter15 : struct.success.entrySet())
            {
              oprot.writeDouble(_iter15.getKey());
              oprot.writeDouble(_iter15.getValue());
            }
          }
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, queryHourKPI_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          {
            org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.DOUBLE, org.apache.thrift.protocol.TType.DOUBLE, iprot.readI32());
            struct.success = new HashMap<Double,Double>(2*_map16.size);
            for (int _i17 = 0; _i17 < _map16.size; ++_i17)
            {
              double _key18;
              double _val19;
              _key18 = iprot.readDouble();
              _val19 = iprot.readDouble();
              struct.success.put(_key18, _val19);
            }
          }
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
