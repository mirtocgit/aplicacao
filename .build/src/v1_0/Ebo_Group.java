package v1_0;

import netgest.bo.runtime.*;
import netgest.bo.data.*;
import netgest.bo.def.*;
import netgest.bo.security.*;
import netgest.utils.*;
import netgest.io.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.ArrayList;
import java.io.*;
import java.math.*;



public  class Ebo_Group extends boObject implements  Serializable {  

   
   
   
    public netgest.bo.runtime.attributes.boAttributeString id;    
    public netgest.bo.runtime.attributes.boAttributeString email;    
    public netgest.bo.runtime.attributes.boAttributeString name;    
    public netgest.bo.runtime.attributes.boAttributeString notifica;    
    public netgest.bo.runtime.attributes.boAttributeObject templateEmail;    
    public netgest.bo.runtime.attributes.boAttributeObject PARENT;    
    public netgest.bo.runtime.attributes.boAttributeObject PARENTCTX;    
    public netgest.bo.runtime.attributes.boAttributeObject TEMPLATE;    
    public netgest.bo.runtime.attributes.boAttributeNumber BOUI;    
    public netgest.bo.runtime.attributes.boAttributeString CLASSNAME;    
    public netgest.bo.runtime.attributes.boAttributeObject CREATOR;    
    public netgest.bo.runtime.attributes.boAttributeDate SYS_DTCREATE;    
    public netgest.bo.runtime.attributes.boAttributeDate SYS_DTSAVE;    
    public netgest.bo.runtime.attributes.boAttributeString SYS_ORIGIN;    
    public netgest.bo.runtime.attributes.boAttributeObject SYS_FROMOBJ;    
    public netgest.bo.runtime.attributes.boAttributeString lastname;    
    public netgest.bo.runtime.attributes.boAttributeString telemovel;    
    public netgest.bo.runtime.attributes.boAttributeString fax;    
    public netgest.bo.runtime.attributes.boAttributeObject office_address;    
    public netgest.bo.runtime.attributes.boAttributeObject home_address;    
    public netgest.bo.runtime.attributes.boAttributeObject holiday_address;    
    public netgest.bo.runtime.attributes.boAttributeObject correspondencia_address;    
    public netgest.bo.runtime.attributes.boAttributeObject empresa;    
    public netgest.bo.runtime.attributes.boAttributeString preferedMedia;    
   
    public Handlerstate state;    
     
    public Ebo_Group() {
        super();
        bo_version      = "1.0";
        bo_name         = "Ebo_Group";
        bo_classregboui = "#BO.CLSREGBOUI#";
        bo_definition   = boDefHandler.getBoDefinition("Ebo_Group");
        bo_statemanager = bo_definition.getBoClsState() != null ? bo_definition.getBoClsState().getStateManager( this ) : null;  

        boAttributesArray atts = super.getAttributes();
        boAttributesArray stat = super.getStateAttributes();

       
        
        
        atts.add(new boBridgeMasterAttribute(this,this.getBoDefinition().getAttributeRef("administrator")));  
        atts.add(new boBridgeMasterAttribute(this,this.getBoDefinition().getAttributeRef("childGroups")));  
        atts.add(new boBridgeMasterAttribute(this,this.getBoDefinition().getAttributeRef("addresses"))); 

       
        
       
        atts.add(id = new netgest.bo.runtime.attributes.boAttributeString(this,"id"));
        
        atts.add(email = new netgest.bo.runtime.attributes.boAttributeString(this,"email"));
        
        atts.add(name = new netgest.bo.runtime.attributes.boAttributeString(this,"name"));
        
        atts.add(notifica = new netgest.bo.runtime.attributes.boAttributeString(this,"notifica"));
        
        atts.add(templateEmail = new netgest.bo.runtime.attributes.boAttributeObject(this,"templateEmail"));
        
        atts.add(PARENT = new netgest.bo.runtime.attributes.boAttributeObject(this,"PARENT"));
        
        atts.add(PARENTCTX = new netgest.bo.runtime.attributes.boAttributeObject(this,"PARENTCTX"));
        
        atts.add(TEMPLATE = new netgest.bo.runtime.attributes.boAttributeObject(this,"TEMPLATE"));
        
        atts.add(BOUI = new netgest.bo.runtime.attributes.boAttributeNumber(this,"BOUI"));
        
        atts.add(CLASSNAME = new netgest.bo.runtime.attributes.boAttributeString(this,"CLASSNAME"));
        
        atts.add(CREATOR = new netgest.bo.runtime.attributes.boAttributeObject(this,"CREATOR"));
        
        atts.add(SYS_DTCREATE = new netgest.bo.runtime.attributes.boAttributeDate(this,"SYS_DTCREATE"));
        
        atts.add(SYS_DTSAVE = new netgest.bo.runtime.attributes.boAttributeDate(this,"SYS_DTSAVE"));
        
        atts.add(SYS_ORIGIN = new netgest.bo.runtime.attributes.boAttributeString(this,"SYS_ORIGIN"));
        
        atts.add(SYS_FROMOBJ = new netgest.bo.runtime.attributes.boAttributeObject(this,"SYS_FROMOBJ"));
        
        atts.add(lastname = new netgest.bo.runtime.attributes.boAttributeString(this,"lastname"));
        
        atts.add(telemovel = new netgest.bo.runtime.attributes.boAttributeString(this,"telemovel"));
        
        atts.add(fax = new netgest.bo.runtime.attributes.boAttributeString(this,"fax"));
        
        atts.add(office_address = new netgest.bo.runtime.attributes.boAttributeObject(this,"office_address"));
        
        atts.add(home_address = new netgest.bo.runtime.attributes.boAttributeObject(this,"home_address"));
        
        atts.add(holiday_address = new netgest.bo.runtime.attributes.boAttributeObject(this,"holiday_address"));
        
        atts.add(correspondencia_address = new netgest.bo.runtime.attributes.boAttributeObject(this,"correspondencia_address"));
        
        atts.add(empresa = new netgest.bo.runtime.attributes.boAttributeObject(this,"empresa"));
        
        atts.add(preferedMedia = new netgest.bo.runtime.attributes.boAttributeString(this,"preferedMedia"));
        



       
        atts.add(state = new Handlerstate(this));
        stat.add(state);
        
    }
		private BigDecimal verifyTransformer(ObjAttHandler att, BigDecimal boui)
    {
        try
        {
            netgest.bo.transformers.Transformer transfClass = null;
            if((transfClass = att.getDefAttribute().getTransformClassMap()) != null)
            {
                if(boui != null && att.getParent().getMode() != boObject.MODE_EDIT_TEMPLATE )
                {
                    boui = new BigDecimal(transfClass.transform(getEboContext(), att.getParent(), boui.longValue()));
                }
            }
        }
        catch (boRuntimeException e)
        {
            
        }
        return boui;
    }
    public void init() throws boRuntimeException {
        super.init();
        setModeView();
        if(p_mode == MODE_NEW && !p_clone)
        {
           
           
           
                if( id.haveDefaultValue()) 
                {
                	if(id.defaultValue() != null)
                	{
                    	id._setValue(boConvertUtils.convertToString(id.defaultValue(), id));
                    }
                    else
                    {
                    	id._setValue(null);
                    }
                    id.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( email.haveDefaultValue()) 
                {
                	if(email.defaultValue() != null)
                	{
                    	email._setValue(boConvertUtils.convertToString(email.defaultValue(), email));
                    }
                    else
                    {
                    	email._setValue(null);
                    }
                    email.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( name.haveDefaultValue()) 
                {
                	if(name.defaultValue() != null)
                	{
                    	name._setValue(boConvertUtils.convertToString(name.defaultValue(), name));
                    }
                    else
                    {
                    	name._setValue(null);
                    }
                    name.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( notifica.haveDefaultValue()) 
                {
                	if(notifica.defaultValue() != null)
                	{
                    	notifica._setValue(boConvertUtils.convertToString(notifica.defaultValue(), notifica));
                    }
                    else
                    {
                    	notifica._setValue(null);
                    }
                    notifica.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( templateEmail.haveDefaultValue()) 
                {
                	if(templateEmail.defaultValue() != null)
                	{
                    	templateEmail._setValue(boConvertUtils.convertToBigDecimal(templateEmail.defaultValue(), templateEmail));
                    }
                    else
                    {
                    	templateEmail._setValue(null);
                    }
                    templateEmail.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( PARENT.haveDefaultValue()) 
                {
                	if(PARENT.defaultValue() != null)
                	{
                    	PARENT._setValue(boConvertUtils.convertToBigDecimal(PARENT.defaultValue(), PARENT));
                    }
                    else
                    {
                    	PARENT._setValue(null);
                    }
                    PARENT.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( PARENTCTX.haveDefaultValue()) 
                {
                	if(PARENTCTX.defaultValue() != null)
                	{
                    	PARENTCTX._setValue(boConvertUtils.convertToBigDecimal(PARENTCTX.defaultValue(), PARENTCTX));
                    }
                    else
                    {
                    	PARENTCTX._setValue(null);
                    }
                    PARENTCTX.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( TEMPLATE.haveDefaultValue()) 
                {
                	if(TEMPLATE.defaultValue() != null)
                	{
                    	TEMPLATE._setValue(boConvertUtils.convertToBigDecimal(TEMPLATE.defaultValue(), TEMPLATE));
                    }
                    else
                    {
                    	TEMPLATE._setValue(null);
                    }
                    TEMPLATE.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( BOUI.haveDefaultValue()) 
                {
                	if(BOUI.defaultValue() != null)
                	{
                    	BOUI._setValue(boConvertUtils.convertToBigDecimal(BOUI.defaultValue(), BOUI));
                    }
                    else
                    {
                    	BOUI._setValue(null);
                    }
                    BOUI.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( CLASSNAME.haveDefaultValue()) 
                {
                	if(CLASSNAME.defaultValue() != null)
                	{
                    	CLASSNAME._setValue(boConvertUtils.convertToString(CLASSNAME.defaultValue(), CLASSNAME));
                    }
                    else
                    {
                    	CLASSNAME._setValue(null);
                    }
                    CLASSNAME.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( CREATOR.haveDefaultValue()) 
                {
                	if(CREATOR.defaultValue() != null)
                	{
                    	CREATOR._setValue(boConvertUtils.convertToBigDecimal(CREATOR.defaultValue(), CREATOR));
                    }
                    else
                    {
                    	CREATOR._setValue(null);
                    }
                    CREATOR.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( SYS_DTCREATE.haveDefaultValue()) 
                {
                	if(SYS_DTCREATE.defaultValue() != null)
                	{
                    	SYS_DTCREATE._setValue(boConvertUtils.convertToTimestamp(SYS_DTCREATE.defaultValue(), SYS_DTCREATE));
                    }
                    else
                    {
                    	SYS_DTCREATE._setValue(null);
                    }
                    SYS_DTCREATE.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( SYS_DTSAVE.haveDefaultValue()) 
                {
                	if(SYS_DTSAVE.defaultValue() != null)
                	{
                    	SYS_DTSAVE._setValue(boConvertUtils.convertToTimestamp(SYS_DTSAVE.defaultValue(), SYS_DTSAVE));
                    }
                    else
                    {
                    	SYS_DTSAVE._setValue(null);
                    }
                    SYS_DTSAVE.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( SYS_ORIGIN.haveDefaultValue()) 
                {
                	if(SYS_ORIGIN.defaultValue() != null)
                	{
                    	SYS_ORIGIN._setValue(boConvertUtils.convertToString(SYS_ORIGIN.defaultValue(), SYS_ORIGIN));
                    }
                    else
                    {
                    	SYS_ORIGIN._setValue(null);
                    }
                    SYS_ORIGIN.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( SYS_FROMOBJ.haveDefaultValue()) 
                {
                	if(SYS_FROMOBJ.defaultValue() != null)
                	{
                    	SYS_FROMOBJ._setValue(boConvertUtils.convertToBigDecimal(SYS_FROMOBJ.defaultValue(), SYS_FROMOBJ));
                    }
                    else
                    {
                    	SYS_FROMOBJ._setValue(null);
                    }
                    SYS_FROMOBJ.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( lastname.haveDefaultValue()) 
                {
                	if(lastname.defaultValue() != null)
                	{
                    	lastname._setValue(boConvertUtils.convertToString(lastname.defaultValue(), lastname));
                    }
                    else
                    {
                    	lastname._setValue(null);
                    }
                    lastname.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( telemovel.haveDefaultValue()) 
                {
                	if(telemovel.defaultValue() != null)
                	{
                    	telemovel._setValue(boConvertUtils.convertToString(telemovel.defaultValue(), telemovel));
                    }
                    else
                    {
                    	telemovel._setValue(null);
                    }
                    telemovel.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( fax.haveDefaultValue()) 
                {
                	if(fax.defaultValue() != null)
                	{
                    	fax._setValue(boConvertUtils.convertToString(fax.defaultValue(), fax));
                    }
                    else
                    {
                    	fax._setValue(null);
                    }
                    fax.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( office_address.haveDefaultValue()) 
                {
                	if(office_address.defaultValue() != null)
                	{
                    	office_address._setValue(boConvertUtils.convertToBigDecimal(office_address.defaultValue(), office_address));
                    }
                    else
                    {
                    	office_address._setValue(null);
                    }
                    office_address.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( home_address.haveDefaultValue()) 
                {
                	if(home_address.defaultValue() != null)
                	{
                    	home_address._setValue(boConvertUtils.convertToBigDecimal(home_address.defaultValue(), home_address));
                    }
                    else
                    {
                    	home_address._setValue(null);
                    }
                    home_address.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( holiday_address.haveDefaultValue()) 
                {
                	if(holiday_address.defaultValue() != null)
                	{
                    	holiday_address._setValue(boConvertUtils.convertToBigDecimal(holiday_address.defaultValue(), holiday_address));
                    }
                    else
                    {
                    	holiday_address._setValue(null);
                    }
                    holiday_address.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( correspondencia_address.haveDefaultValue()) 
                {
                	if(correspondencia_address.defaultValue() != null)
                	{
                    	correspondencia_address._setValue(boConvertUtils.convertToBigDecimal(correspondencia_address.defaultValue(), correspondencia_address));
                    }
                    else
                    {
                    	correspondencia_address._setValue(null);
                    }
                    correspondencia_address.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( empresa.haveDefaultValue()) 
                {
                	if(empresa.defaultValue() != null)
                	{
                    	empresa._setValue(boConvertUtils.convertToBigDecimal(empresa.defaultValue(), empresa));
                    }
                    else
                    {
                    	empresa._setValue(null);
                    }
                    empresa.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
                if( preferedMedia.haveDefaultValue()) 
                {
                	if(preferedMedia.defaultValue() != null)
                	{
                    	preferedMedia._setValue(boConvertUtils.convertToString(preferedMedia.defaultValue(), preferedMedia));
                    }
                    else
                    {
                    	preferedMedia._setValue(null);
                    }
                    preferedMedia.setInputType( AttributeHandler.INPUT_FROM_DEFAULT );
                }
            
    
            if("Ebo_Group".equals(this.getName()))
            {
                calculateFormula(null);
            }
        }
    }
   
    public bridgeHandler administrator()
    {
        return getBridge("administrator");        
    }
    
    public bridgeHandler childGroups()
    {
        return getBridge("childGroups");        
    }
    
    public bridgeHandler addresses()
    {
        return getBridge("addresses");        
    }
    
    
    public bridgeHandler getBridge( String bridgeName ) 
    {
        boBridgesArray    brig = super.getBridges();        	
        bridgeHandler     ret  = brig.get(bridgeName);
        if( ret == null )
        {
        
        	if( bridgeName.equals("administrator") && (ret=brig.get("administrator"))==null )
        	{
            	brig.add( ret=new BridgeHandleradministrator(new DataResultSet( getBridgeDataSet("administrator") ) , this ) );        
        	}
        	if( bridgeName.equals("childGroups") && (ret=brig.get("childGroups"))==null )
        	{
            	brig.add( ret=new BridgeHandlerchildGroups(new DataResultSet( getBridgeDataSet("childGroups") ) , this ) );        
        	}
        	if( bridgeName.equals("addresses") && (ret=brig.get("addresses"))==null )
        	{
            	brig.add( ret=new BridgeHandleraddresses(new DataResultSet( getBridgeDataSet("addresses") ) , this ) );        
        	}
        	if( ret == null )
        	{
				ret = super.getBridge( bridgeName );
        	}
        }
        return ret;
    }
   
    
    
    public final class BridgeHandleradministrator extends bridgeHandler {
        private DataResultSet p_node;
        private String        p_fatherfield;
        private String        p_childfield;
        private boObject      p_parent;

        
        public BridgeHandleradministrator(DataResultSet data,boObject parent) {
            super("administrator",
                  data,
                  parent.getBoDefinition().getAttributeRef("administrator").getBridge().getChildFieldName(),
                  parent
                 );

            p_fatherfield = parent.getBoDefinition().getAttributeRef("administrator").getBridge().getFatherFieldName();
            p_childfield  = parent.getBoDefinition().getAttributeRef("administrator").getBridge().getChildFieldName();
            
            p_parent = parent;
            p_node = data;

			refreshBridgeData();
            first();
        }
        public void add(BigDecimal boui, byte type) throws boRuntimeException {
            add(boui,-1, type);
        }
        public void add(BigDecimal boui,int xnrow, byte type) throws boRuntimeException {

              //tranform ao adicionar a brige
              netgest.bo.transformers.Transformer transfClass = null;
			  if ( getParent().getMode() != boObject.MODE_EDIT_TEMPLATE )
				{
				  if(( transfClass = this.getDefAttribute().getTransformClassMap()) != null)
				  {
					 if(boui != null)
					 {
						boui = new BigDecimal(transfClass.transform(getEboContext(), getParent(), boui.longValue()));
					 }
				  }
				}

			  boBridgeRow brow = createRow();
			  ObjAttHandler att = (ObjAttHandler)brow.getAttribute( this.getName() );

			  BigDecimal newval = boui;

			  if( att.fireBeforeChangeEvent( att, null, newval) ) 
			  {
				  
				  brow.getDataRow().updateBigDecimal(p_childfield,boui);
  		          this.insertRow( brow );
				  this.moveTo( this.getRowCount() );

				  if(xnrow !=-1)
                  {
                      this.moveRowTo(xnrow);
                  }

				  att.checkParent( null, newval );

				  getParent().setChanged( true );

                  if(getParent().onChangeSubmit("administrator"))
                  {
                      getParent().calculateFormula("administrator");
                  }
                  att.fireAfterChangeEvent( att, null, newval );
			  }

        }

		public boolean remove() throws boRuntimeException 
        {
            boolean ret = false;

          

                boBridgeRow rowtodelete = rows( this.getRow() );
				ObjAttHandler att = (ObjAttHandler)rowtodelete.getAttribute( this.getName() );

				BigDecimal chgval = this.getValue();

                if( att.fireBeforeChangeEvent( att, chgval, null) ) 
                {
					rowtodelete.getDataRow().updateBigDecimal(p_childfield,null);
					att.checkParent( chgval, null );

				    getParent().setChanged( true );

                    Enumeration  lineatts = rowtodelete.getLineAttributes().elements();

                    _remove( rowtodelete );  // remove the line

					
                    while( lineatts.hasMoreElements() )
                    {
                        AttributeHandler xatt = ( AttributeHandler )lineatts.nextElement();
                        if ( xatt.getValueObject() != null )
                        {
                            xatt.setValueObject( null );
                        }
                    }
                    
                    ret = true;
					//calculateFormulas
					if(getParent().onChangeSubmit("administrator"))
					{
					   getParent().calculateFormula("administrator");
					}

                    att.fireAfterChangeEvent( att, chgval, null);
				}
           
            return ret;
        }




		public boBridgeRow createRow( netgest.bo.data.DataRow row )
		{
			return new BridgeHanlderadministratorRow( this, row );
		}

		public final class BridgeHanlderadministratorRow extends boBridgeRow
		{
			public BridgeHanlderadministratorRow( bridgeHandler bridge, netgest.bo.data.DataRow row )
			{
				super( bridge , row );
				addLine();
			}

			public void addLine() 
			{
				boAttributesArray xatt = super.getLineAttributes();
			
				if(this.getAttribute("administrator")==null)
					xatt.add( new Handleradministrator( getParent(), this ) );
				
		
			
				if(this.getAttribute("LIN")==null)
					xatt.add( new HandlerLIN( getParent(), this ) );
				
			} 


		}


        
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



        
       
        public final class Handleradministrator extends BridgeObjAttributeHandler {
            public Handleradministrator( boObject parent , boBridgeRow bridgerow ) {
                super( parent , bridgerow , bridgerow.getBridge().getDefAttribute().getName().equals("administrator")?parent.getBoDefinition().getAttributeRef("administrator"):bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("administrator") );
            }
            public void setValueString(String value) {
                try {
                    this.setValue(boConvertUtils.convertToBigDecimal(value,this));
                    if(getParent().onChangeSubmit("administrator"))
                    {
                        Hashtable table = new Hashtable();                    
                        getParent().setCalculated(table, "administrator");
                        getParent().calculateFormula(table, "administrator");
                    }
                } catch (Exception e) {
                    super.setInvalid(e.getMessage(),value);
                }
            }
            public String getValueString() throws boRuntimeException {
                try {
                    return boConvertUtils.convertToString(this.getValue(),this);
                } catch (Exception e) {
                    String[] args = {getParent().getName(),"administrator"};
                    throw new boRuntimeException(this.getClass().getName()+".load(EboContext,long)","BO-3003",e,args);
                }
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "administrator"))
                    {
                       getParent().setCalculated(table, "administrator");
                       this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "administrator"))
                    {
                        getParent().setCalculated(table, "administrator");
                        this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("administrator"))
                    {
                        getParent().setCalculated(table, "administrator"); 
                    }
                    else
                    {
                        getParent().clear(table, "administrator"); 
                        this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                }
                else
                {   
                    this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    if(getParent().onChangeSubmit("administrator"))
                    {                 
                        getParent().setWaiting(table, "administrator");
                        getParent().calculateFormula(new Hashtable(table), "administrator");
                    }                    
                }
            }

            public void setValue(BigDecimal newval, boolean recalc) throws boRuntimeException 
            {
                this.setValue(newval, recalc ? AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL);
	        	
                if( recalc && getParent().onChangeSubmit("administrator"))
                {
                    Hashtable table = new Hashtable();
                    getParent().setCalculated(table, "administrator");
                    getParent().calculateFormula(table, "administrator");
                }
        
				if ( getParent().p_parentBridgeRow != null )
				{
					getParent().getParentBridgeRow().getBridge().lineChanged("administrator");
				}
            }

            private void setValue(BigDecimal newval, Hashtable table) throws boRuntimeException 
            {
                this.setValue(newval, AttributeHandler.INPUT_FROM_INTERNAL);
                if( getParent().onChangeSubmit("administrator"))
                {
                    getParent().setCalculated(table, "administrator");
                    getParent().calculateFormula(table, "administrator");
                }
                
				//vou verificar se o objecto se encontra numa bridge
				if ( getParent().p_parentBridgeRow != null )
				{
					getParent().getParentBridgeRow().getBridge().lineChanged("administrator");
				}

            }
            
            

            
        }
        

       
        public final class HandlerLIN extends BridgeAttributeHandler {

            private boolean isdbbinding=true;
            private BigDecimal fieldvalue;
            private boBridgeRow p_bridgerow;

			public HandlerLIN(boObject parent, boBridgeRow bridgerow ) {
                super( parent , bridgerow ,bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("LIN") );
                p_bridgerow = bridgerow;
            }
            
            public BigDecimal getValue() throws boRuntimeException {
                BigDecimal ret = null;

                fireEvent( boEvent.EVENT_BEFORE_GETVALUE, null );
                if(isdbbinding) {
					ret=p_bridgerow.getDataRow().getBigDecimal("LIN");
                } else {
                    ret = fieldvalue;
                }
                fireEvent( boEvent.EVENT_AFTER_GETVALUE, ret );
                return ret;
            }
            public void setValueObject(Object value) throws boRuntimeException {
                this.setValue((BigDecimal)value);
            }
            public Object getValueObject() throws boRuntimeException 
            {
                return this.getValue();
            }
            public String getValueString() throws boRuntimeException {
                return boConvertUtils.convertToString(this.getValue(),this);
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "LIN"))
                    {
                       getParent().setCalculated(table, "LIN");
                       setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "LIN"))
                    {
                        getParent().setCalculated(table, "LIN");
                        setValue(boConvertUtils.convertToBigDecimal(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("LIN"))
                    {
                        getParent().setCalculated(table, "LIN"); 
                    }
                    else
                    {
                        getParent().clear(table, "LIN"); 
                        setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    } 
                }
                else
                {    
                    setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );                
                    if(getParent().onChangeSubmit("LIN"))
                    {
                        getParent().setWaiting(table, "LIN");
                        getParent().calculateFormula(new Hashtable(table), "LIN");
                    }                    
                }
            }

            public void setValue(BigDecimal newval ) throws boRuntimeException
            {
                setValue( newval, true );
            }

            public void setValue(BigDecimal newval, boolean recalc) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(HandlerLIN.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    BigDecimal chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
                            if(canAlter(recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL))
                            {
    	                        _setValue(newval);
                                setInputType( recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL );
	                    	                        
                                if( recalc && getParent().onChangeSubmit("LIN"))
                                {
                                    Hashtable table = new Hashtable();
                                    getParent().setCalculated(table, "LIN");
                                    getParent().calculateFormula(table, "LIN");
                                }
	                        
                                //vou verificar se o objecto se encontra numa bridge
                                if ( getParent().p_parentBridgeRow != null )
                                {
                                    getParent().getParentBridgeRow().getBridge().lineChanged("LIN");
                                }

                                fireAfterChangeEvent( this, chgval, newval);
                            }
                    }
                }
            }

            private void setValue(BigDecimal newval, Hashtable table) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(HandlerLIN.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    BigDecimal chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
											  if(canAlter(AttributeHandler.INPUT_FROM_INTERNAL))
												{
	                        _setValue(newval);
	                        setInputType( AttributeHandler.INPUT_FROM_INTERNAL );
	                        if( getParent().onChangeSubmit("LIN"))
	                        {
	                            getParent().setCalculated(table, "LIN");
	                            getParent().calculateFormula(table, "LIN");
	                        }

							//vou verificar se o objecto se encontra numa bridge
							if ( getParent().p_parentBridgeRow != null )
							{
								getParent().getParentBridgeRow().getBridge().lineChanged("LIN");
							}
	
                            fireAfterChangeEvent( this, chgval, newval);
	                    }
	                }
							}
            }

            public void _setValue(BigDecimal newval) throws boRuntimeException {
                if(isdbbinding) {

                        p_bridgerow.getDataRow().updateBigDecimal("LIN",newval);
                        getParent().setChanged(true);
                        super.setValid();

                } else {
                    fieldvalue = newval;
                }
            }
            public void setValueString(String value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }

            //@IF SIMPLEDATATYPE
            public double getValueDouble() throws boRuntimeException {
                return boConvertUtils.convertTodouble(this.getValue(),this);
            }
            public void setValue(double value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }
            public void setValuedouble(double value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }
            //@ENDIF SIMPLEDATATYPE

            
            
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



            
        }
        
    } 
     
    public final class BridgeHandlerchildGroups extends bridgeHandler {
        private DataResultSet p_node;
        private String        p_fatherfield;
        private String        p_childfield;
        private boObject      p_parent;

        
        public BridgeHandlerchildGroups(DataResultSet data,boObject parent) {
            super("childGroups",
                  data,
                  parent.getBoDefinition().getAttributeRef("childGroups").getBridge().getChildFieldName(),
                  parent
                 );

            p_fatherfield = parent.getBoDefinition().getAttributeRef("childGroups").getBridge().getFatherFieldName();
            p_childfield  = parent.getBoDefinition().getAttributeRef("childGroups").getBridge().getChildFieldName();
            
            p_parent = parent;
            p_node = data;

			refreshBridgeData();
            first();
        }
        public void add(BigDecimal boui, byte type) throws boRuntimeException {
            add(boui,-1, type);
        }
        public void add(BigDecimal boui,int xnrow, byte type) throws boRuntimeException {

              //tranform ao adicionar a brige
              netgest.bo.transformers.Transformer transfClass = null;
			  if ( getParent().getMode() != boObject.MODE_EDIT_TEMPLATE )
				{
				  if(( transfClass = this.getDefAttribute().getTransformClassMap()) != null)
				  {
					 if(boui != null)
					 {
						boui = new BigDecimal(transfClass.transform(getEboContext(), getParent(), boui.longValue()));
					 }
				  }
				}

			  boBridgeRow brow = createRow();
			  ObjAttHandler att = (ObjAttHandler)brow.getAttribute( this.getName() );

			  BigDecimal newval = boui;

			  if( att.fireBeforeChangeEvent( att, null, newval) ) 
			  {
				  
				  brow.getDataRow().updateBigDecimal(p_childfield,boui);
  		          this.insertRow( brow );
				  this.moveTo( this.getRowCount() );

				  if(xnrow !=-1)
                  {
                      this.moveRowTo(xnrow);
                  }

				  att.checkParent( null, newval );

				  getParent().setChanged( true );

                  if(getParent().onChangeSubmit("childGroups"))
                  {
                      getParent().calculateFormula("childGroups");
                  }
                  att.fireAfterChangeEvent( att, null, newval );
			  }

        }

		public boolean remove() throws boRuntimeException 
        {
            boolean ret = false;

          

                boBridgeRow rowtodelete = rows( this.getRow() );
				ObjAttHandler att = (ObjAttHandler)rowtodelete.getAttribute( this.getName() );

				BigDecimal chgval = this.getValue();

                if( att.fireBeforeChangeEvent( att, chgval, null) ) 
                {
					rowtodelete.getDataRow().updateBigDecimal(p_childfield,null);
					att.checkParent( chgval, null );

				    getParent().setChanged( true );

                    Enumeration  lineatts = rowtodelete.getLineAttributes().elements();

                    _remove( rowtodelete );  // remove the line

					
                    while( lineatts.hasMoreElements() )
                    {
                        AttributeHandler xatt = ( AttributeHandler )lineatts.nextElement();
                        if ( xatt.getValueObject() != null )
                        {
                            xatt.setValueObject( null );
                        }
                    }
                    
                    ret = true;
					//calculateFormulas
					if(getParent().onChangeSubmit("childGroups"))
					{
					   getParent().calculateFormula("childGroups");
					}

                    att.fireAfterChangeEvent( att, chgval, null);
				}
           
            return ret;
        }




		public boBridgeRow createRow( netgest.bo.data.DataRow row )
		{
			return new BridgeHanlderchildGroupsRow( this, row );
		}

		public final class BridgeHanlderchildGroupsRow extends boBridgeRow
		{
			public BridgeHanlderchildGroupsRow( bridgeHandler bridge, netgest.bo.data.DataRow row )
			{
				super( bridge , row );
				addLine();
			}

			public void addLine() 
			{
				boAttributesArray xatt = super.getLineAttributes();
			
				if(this.getAttribute("childGroups")==null)
					xatt.add( new HandlerchildGroups( getParent(), this ) );
				
		
			
				if(this.getAttribute("LIN")==null)
					xatt.add( new HandlerLIN( getParent(), this ) );
				
			} 


		}


        
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



        
       
        public final class HandlerchildGroups extends BridgeObjAttributeHandler {
            public HandlerchildGroups( boObject parent , boBridgeRow bridgerow ) {
                super( parent , bridgerow , bridgerow.getBridge().getDefAttribute().getName().equals("childGroups")?parent.getBoDefinition().getAttributeRef("childGroups"):bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("childGroups") );
            }
            public void setValueString(String value) {
                try {
                    this.setValue(boConvertUtils.convertToBigDecimal(value,this));
                    if(getParent().onChangeSubmit("childGroups"))
                    {
                        Hashtable table = new Hashtable();                    
                        getParent().setCalculated(table, "childGroups");
                        getParent().calculateFormula(table, "childGroups");
                    }
                } catch (Exception e) {
                    super.setInvalid(e.getMessage(),value);
                }
            }
            public String getValueString() throws boRuntimeException {
                try {
                    return boConvertUtils.convertToString(this.getValue(),this);
                } catch (Exception e) {
                    String[] args = {getParent().getName(),"childGroups"};
                    throw new boRuntimeException(this.getClass().getName()+".load(EboContext,long)","BO-3003",e,args);
                }
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "childGroups"))
                    {
                       getParent().setCalculated(table, "childGroups");
                       this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "childGroups"))
                    {
                        getParent().setCalculated(table, "childGroups");
                        this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("childGroups"))
                    {
                        getParent().setCalculated(table, "childGroups"); 
                    }
                    else
                    {
                        getParent().clear(table, "childGroups"); 
                        this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                }
                else
                {   
                    this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    if(getParent().onChangeSubmit("childGroups"))
                    {                 
                        getParent().setWaiting(table, "childGroups");
                        getParent().calculateFormula(new Hashtable(table), "childGroups");
                    }                    
                }
            }

            public void setValue(BigDecimal newval, boolean recalc) throws boRuntimeException 
            {
                this.setValue(newval, recalc ? AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL);
	        	
                if( recalc && getParent().onChangeSubmit("childGroups"))
                {
                    Hashtable table = new Hashtable();
                    getParent().setCalculated(table, "childGroups");
                    getParent().calculateFormula(table, "childGroups");
                }
        
				if ( getParent().p_parentBridgeRow != null )
				{
					getParent().getParentBridgeRow().getBridge().lineChanged("childGroups");
				}
            }

            private void setValue(BigDecimal newval, Hashtable table) throws boRuntimeException 
            {
                this.setValue(newval, AttributeHandler.INPUT_FROM_INTERNAL);
                if( getParent().onChangeSubmit("childGroups"))
                {
                    getParent().setCalculated(table, "childGroups");
                    getParent().calculateFormula(table, "childGroups");
                }
                
				//vou verificar se o objecto se encontra numa bridge
				if ( getParent().p_parentBridgeRow != null )
				{
					getParent().getParentBridgeRow().getBridge().lineChanged("childGroups");
				}

            }
            
            

            
        }
        

       
        public final class HandlerLIN extends BridgeAttributeHandler {

            private boolean isdbbinding=true;
            private BigDecimal fieldvalue;
            private boBridgeRow p_bridgerow;

			public HandlerLIN(boObject parent, boBridgeRow bridgerow ) {
                super( parent , bridgerow ,bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("LIN") );
                p_bridgerow = bridgerow;
            }
            
            public BigDecimal getValue() throws boRuntimeException {
                BigDecimal ret = null;

                fireEvent( boEvent.EVENT_BEFORE_GETVALUE, null );
                if(isdbbinding) {
					ret=p_bridgerow.getDataRow().getBigDecimal("LIN");
                } else {
                    ret = fieldvalue;
                }
                fireEvent( boEvent.EVENT_AFTER_GETVALUE, ret );
                return ret;
            }
            public void setValueObject(Object value) throws boRuntimeException {
                this.setValue((BigDecimal)value);
            }
            public Object getValueObject() throws boRuntimeException 
            {
                return this.getValue();
            }
            public String getValueString() throws boRuntimeException {
                return boConvertUtils.convertToString(this.getValue(),this);
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "LIN"))
                    {
                       getParent().setCalculated(table, "LIN");
                       setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "LIN"))
                    {
                        getParent().setCalculated(table, "LIN");
                        setValue(boConvertUtils.convertToBigDecimal(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("LIN"))
                    {
                        getParent().setCalculated(table, "LIN"); 
                    }
                    else
                    {
                        getParent().clear(table, "LIN"); 
                        setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    } 
                }
                else
                {    
                    setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );                
                    if(getParent().onChangeSubmit("LIN"))
                    {
                        getParent().setWaiting(table, "LIN");
                        getParent().calculateFormula(new Hashtable(table), "LIN");
                    }                    
                }
            }

            public void setValue(BigDecimal newval ) throws boRuntimeException
            {
                setValue( newval, true );
            }

            public void setValue(BigDecimal newval, boolean recalc) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(HandlerLIN.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    BigDecimal chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
                            if(canAlter(recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL))
                            {
    	                        _setValue(newval);
                                setInputType( recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL );
	                    	                        
                                if( recalc && getParent().onChangeSubmit("LIN"))
                                {
                                    Hashtable table = new Hashtable();
                                    getParent().setCalculated(table, "LIN");
                                    getParent().calculateFormula(table, "LIN");
                                }
	                        
                                //vou verificar se o objecto se encontra numa bridge
                                if ( getParent().p_parentBridgeRow != null )
                                {
                                    getParent().getParentBridgeRow().getBridge().lineChanged("LIN");
                                }

                                fireAfterChangeEvent( this, chgval, newval);
                            }
                    }
                }
            }

            private void setValue(BigDecimal newval, Hashtable table) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(HandlerLIN.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    BigDecimal chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
											  if(canAlter(AttributeHandler.INPUT_FROM_INTERNAL))
												{
	                        _setValue(newval);
	                        setInputType( AttributeHandler.INPUT_FROM_INTERNAL );
	                        if( getParent().onChangeSubmit("LIN"))
	                        {
	                            getParent().setCalculated(table, "LIN");
	                            getParent().calculateFormula(table, "LIN");
	                        }

							//vou verificar se o objecto se encontra numa bridge
							if ( getParent().p_parentBridgeRow != null )
							{
								getParent().getParentBridgeRow().getBridge().lineChanged("LIN");
							}
	
                            fireAfterChangeEvent( this, chgval, newval);
	                    }
	                }
							}
            }

            public void _setValue(BigDecimal newval) throws boRuntimeException {
                if(isdbbinding) {

                        p_bridgerow.getDataRow().updateBigDecimal("LIN",newval);
                        getParent().setChanged(true);
                        super.setValid();

                } else {
                    fieldvalue = newval;
                }
            }
            public void setValueString(String value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }

            //@IF SIMPLEDATATYPE
            public double getValueDouble() throws boRuntimeException {
                return boConvertUtils.convertTodouble(this.getValue(),this);
            }
            public void setValue(double value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }
            public void setValuedouble(double value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }
            //@ENDIF SIMPLEDATATYPE

            
            
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



            
        }
        
    } 
     
    public final class BridgeHandleraddresses extends bridgeHandler {
        private DataResultSet p_node;
        private String        p_fatherfield;
        private String        p_childfield;
        private boObject      p_parent;

        
        public BridgeHandleraddresses(DataResultSet data,boObject parent) {
            super("addresses",
                  data,
                  parent.getBoDefinition().getAttributeRef("addresses").getBridge().getChildFieldName(),
                  parent
                 );

            p_fatherfield = parent.getBoDefinition().getAttributeRef("addresses").getBridge().getFatherFieldName();
            p_childfield  = parent.getBoDefinition().getAttributeRef("addresses").getBridge().getChildFieldName();
            
            p_parent = parent;
            p_node = data;

			refreshBridgeData();
            first();
        }
        public void add(BigDecimal boui, byte type) throws boRuntimeException {
            add(boui,-1, type);
        }
        public void add(BigDecimal boui,int xnrow, byte type) throws boRuntimeException {

              //tranform ao adicionar a brige
              netgest.bo.transformers.Transformer transfClass = null;
			  if ( getParent().getMode() != boObject.MODE_EDIT_TEMPLATE )
				{
				  if(( transfClass = this.getDefAttribute().getTransformClassMap()) != null)
				  {
					 if(boui != null)
					 {
						boui = new BigDecimal(transfClass.transform(getEboContext(), getParent(), boui.longValue()));
					 }
				  }
				}

			  boBridgeRow brow = createRow();
			  ObjAttHandler att = (ObjAttHandler)brow.getAttribute( this.getName() );

			  BigDecimal newval = boui;

			  if( att.fireBeforeChangeEvent( att, null, newval) ) 
			  {
				  
				  brow.getDataRow().updateBigDecimal(p_childfield,boui);
  		          this.insertRow( brow );
				  this.moveTo( this.getRowCount() );

				  if(xnrow !=-1)
                  {
                      this.moveRowTo(xnrow);
                  }

				  att.checkParent( null, newval );

				  getParent().setChanged( true );

                  if(getParent().onChangeSubmit("addresses"))
                  {
                      getParent().calculateFormula("addresses");
                  }
                  att.fireAfterChangeEvent( att, null, newval );
			  }

        }

		public boolean remove() throws boRuntimeException 
        {
            boolean ret = false;

          

                boBridgeRow rowtodelete = rows( this.getRow() );
				ObjAttHandler att = (ObjAttHandler)rowtodelete.getAttribute( this.getName() );

				BigDecimal chgval = this.getValue();

                if( att.fireBeforeChangeEvent( att, chgval, null) ) 
                {
					rowtodelete.getDataRow().updateBigDecimal(p_childfield,null);
					att.checkParent( chgval, null );

				    getParent().setChanged( true );

                    Enumeration  lineatts = rowtodelete.getLineAttributes().elements();

                    _remove( rowtodelete );  // remove the line

					
                    while( lineatts.hasMoreElements() )
                    {
                        AttributeHandler xatt = ( AttributeHandler )lineatts.nextElement();
                        if ( xatt.getValueObject() != null )
                        {
                            xatt.setValueObject( null );
                        }
                    }
                    
                    ret = true;
					//calculateFormulas
					if(getParent().onChangeSubmit("addresses"))
					{
					   getParent().calculateFormula("addresses");
					}

                    att.fireAfterChangeEvent( att, chgval, null);
				}
           
            return ret;
        }




		public boBridgeRow createRow( netgest.bo.data.DataRow row )
		{
			return new BridgeHanlderaddressesRow( this, row );
		}

		public final class BridgeHanlderaddressesRow extends boBridgeRow
		{
			public BridgeHanlderaddressesRow( bridgeHandler bridge, netgest.bo.data.DataRow row )
			{
				super( bridge , row );
				addLine();
			}

			public void addLine() 
			{
				boAttributesArray xatt = super.getLineAttributes();
			
				if(this.getAttribute("addresses")==null)
					xatt.add( new Handleraddresses( getParent(), this ) );
				
		
			
				if(this.getAttribute("tipo")==null)
					xatt.add( new Handlertipo( getParent(), this ) );
				
				if(this.getAttribute("LIN")==null)
					xatt.add( new HandlerLIN( getParent(), this ) );
				
			} 


		}


        
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



        
       
        public final class Handleraddresses extends BridgeObjAttributeHandler {
            public Handleraddresses( boObject parent , boBridgeRow bridgerow ) {
                super( parent , bridgerow , bridgerow.getBridge().getDefAttribute().getName().equals("addresses")?parent.getBoDefinition().getAttributeRef("addresses"):bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("addresses") );
            }
            public void setValueString(String value) {
                try {
                    this.setValue(boConvertUtils.convertToBigDecimal(value,this));
                    if(getParent().onChangeSubmit("addresses"))
                    {
                        Hashtable table = new Hashtable();                    
                        getParent().setCalculated(table, "addresses");
                        getParent().calculateFormula(table, "addresses");
                    }
                } catch (Exception e) {
                    super.setInvalid(e.getMessage(),value);
                }
            }
            public String getValueString() throws boRuntimeException {
                try {
                    return boConvertUtils.convertToString(this.getValue(),this);
                } catch (Exception e) {
                    String[] args = {getParent().getName(),"addresses"};
                    throw new boRuntimeException(this.getClass().getName()+".load(EboContext,long)","BO-3003",e,args);
                }
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "addresses"))
                    {
                       getParent().setCalculated(table, "addresses");
                       this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "addresses"))
                    {
                        getParent().setCalculated(table, "addresses");
                        this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("addresses"))
                    {
                        getParent().setCalculated(table, "addresses"); 
                    }
                    else
                    {
                        getParent().clear(table, "addresses"); 
                        this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                }
                else
                {   
                    this.setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    if(getParent().onChangeSubmit("addresses"))
                    {                 
                        getParent().setWaiting(table, "addresses");
                        getParent().calculateFormula(new Hashtable(table), "addresses");
                    }                    
                }
            }

            public void setValue(BigDecimal newval, boolean recalc) throws boRuntimeException 
            {
                this.setValue(newval, recalc ? AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL);
	        	
                if( recalc && getParent().onChangeSubmit("addresses"))
                {
                    Hashtable table = new Hashtable();
                    getParent().setCalculated(table, "addresses");
                    getParent().calculateFormula(table, "addresses");
                }
        
				if ( getParent().p_parentBridgeRow != null )
				{
					getParent().getParentBridgeRow().getBridge().lineChanged("addresses");
				}
            }

            private void setValue(BigDecimal newval, Hashtable table) throws boRuntimeException 
            {
                this.setValue(newval, AttributeHandler.INPUT_FROM_INTERNAL);
                if( getParent().onChangeSubmit("addresses"))
                {
                    getParent().setCalculated(table, "addresses");
                    getParent().calculateFormula(table, "addresses");
                }
                
				//vou verificar se o objecto se encontra numa bridge
				if ( getParent().p_parentBridgeRow != null )
				{
					getParent().getParentBridgeRow().getBridge().lineChanged("addresses");
				}

            }
            
            

            
        }
        

       
        public final class Handlertipo extends BridgeAttributeHandler {

            private boolean isdbbinding=true;
            private String fieldvalue;
            private boBridgeRow p_bridgerow;

			public Handlertipo(boObject parent, boBridgeRow bridgerow ) {
                super( parent , bridgerow ,bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("tipo") );
                p_bridgerow = bridgerow;
            }
            
            public String getValue() throws boRuntimeException {
                String ret = null;

                fireEvent( boEvent.EVENT_BEFORE_GETVALUE, null );
                if(isdbbinding) {
					ret=p_bridgerow.getDataRow().getString("TIPO");
                } else {
                    ret = fieldvalue;
                }
                fireEvent( boEvent.EVENT_AFTER_GETVALUE, ret );
                return ret;
            }
            public void setValueObject(Object value) throws boRuntimeException {
                this.setValue((String)value);
            }
            public Object getValueObject() throws boRuntimeException 
            {
                return this.getValue();
            }
            public String getValueString() throws boRuntimeException {
                return boConvertUtils.convertToString(this.getValue(),this);
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "tipo"))
                    {
                       getParent().setCalculated(table, "tipo");
                       setValue(boConvertUtils.convertToString(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "tipo"))
                    {
                        getParent().setCalculated(table, "tipo");
                        setValue(boConvertUtils.convertToString(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("tipo"))
                    {
                        getParent().setCalculated(table, "tipo"); 
                    }
                    else
                    {
                        getParent().clear(table, "tipo"); 
                        setValue(boConvertUtils.convertToString(formula(), this), false );
                    } 
                }
                else
                {    
                    setValue(boConvertUtils.convertToString(formula(), this), false );                
                    if(getParent().onChangeSubmit("tipo"))
                    {
                        getParent().setWaiting(table, "tipo");
                        getParent().calculateFormula(new Hashtable(table), "tipo");
                    }                    
                }
            }

            public void setValue(String newval ) throws boRuntimeException
            {
                setValue( newval, true );
            }

            public void setValue(String newval, boolean recalc) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(Handlertipo.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    String chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
                            if(canAlter(recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL))
                            {
    	                        _setValue(newval);
                                setInputType( recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL );
	                    	                        
                                if( recalc && getParent().onChangeSubmit("tipo"))
                                {
                                    Hashtable table = new Hashtable();
                                    getParent().setCalculated(table, "tipo");
                                    getParent().calculateFormula(table, "tipo");
                                }
	                        
                                //vou verificar se o objecto se encontra numa bridge
                                if ( getParent().p_parentBridgeRow != null )
                                {
                                    getParent().getParentBridgeRow().getBridge().lineChanged("tipo");
                                }

                                fireAfterChangeEvent( this, chgval, newval);
                            }
                    }
                }
            }

            private void setValue(String newval, Hashtable table) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(Handlertipo.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    String chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
											  if(canAlter(AttributeHandler.INPUT_FROM_INTERNAL))
												{
	                        _setValue(newval);
	                        setInputType( AttributeHandler.INPUT_FROM_INTERNAL );
	                        if( getParent().onChangeSubmit("tipo"))
	                        {
	                            getParent().setCalculated(table, "tipo");
	                            getParent().calculateFormula(table, "tipo");
	                        }

							//vou verificar se o objecto se encontra numa bridge
							if ( getParent().p_parentBridgeRow != null )
							{
								getParent().getParentBridgeRow().getBridge().lineChanged("tipo");
							}
	
                            fireAfterChangeEvent( this, chgval, newval);
	                    }
	                }
							}
            }

            public void _setValue(String newval) throws boRuntimeException {
                if(isdbbinding) {

                        p_bridgerow.getDataRow().updateString("TIPO",newval);
                        getParent().setChanged(true);
                        super.setValid();

                } else {
                    fieldvalue = newval;
                }
            }
            public void setValueString(String value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToString(value,this));
            }

            // SIMPLEDATATYPE

            
            
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



            
        }
        
        public final class HandlerLIN extends BridgeAttributeHandler {

            private boolean isdbbinding=true;
            private BigDecimal fieldvalue;
            private boBridgeRow p_bridgerow;

			public HandlerLIN(boObject parent, boBridgeRow bridgerow ) {
                super( parent , bridgerow ,bridgerow.getBridge().getDefAttribute().getBridge().getAttributeRef("LIN") );
                p_bridgerow = bridgerow;
            }
            
            public BigDecimal getValue() throws boRuntimeException {
                BigDecimal ret = null;

                fireEvent( boEvent.EVENT_BEFORE_GETVALUE, null );
                if(isdbbinding) {
					ret=p_bridgerow.getDataRow().getBigDecimal("LIN");
                } else {
                    ret = fieldvalue;
                }
                fireEvent( boEvent.EVENT_AFTER_GETVALUE, ret );
                return ret;
            }
            public void setValueObject(Object value) throws boRuntimeException {
                this.setValue((BigDecimal)value);
            }
            public Object getValueObject() throws boRuntimeException 
            {
                return this.getValue();
            }
            public String getValueString() throws boRuntimeException {
                return boConvertUtils.convertToString(this.getValue(),this);
            }
            
            public void setValueFormula(Hashtable table, String[]dependence) throws boRuntimeException
            {
                if(getParent().alreadyCalculated(table, dependence)) 
                {                       
                    if(getParent().isWaiting(table, "LIN"))
                    {
                       getParent().setCalculated(table, "LIN");
                       setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    }
                    else if(!getParent().isCalculated(table, "LIN"))
                    {
                        getParent().setCalculated(table, "LIN");
                        setValue(boConvertUtils.convertToBigDecimal(formula(), this), table );
                    }
                }
                else if(getParent().dependsFromWaiting(table, dependence))
                {
                    if(getParent().onChangeSubmit("LIN"))
                    {
                        getParent().setCalculated(table, "LIN"); 
                    }
                    else
                    {
                        getParent().clear(table, "LIN"); 
                        setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );
                    } 
                }
                else
                {    
                    setValue(boConvertUtils.convertToBigDecimal(formula(), this), false );                
                    if(getParent().onChangeSubmit("LIN"))
                    {
                        getParent().setWaiting(table, "LIN");
                        getParent().calculateFormula(new Hashtable(table), "LIN");
                    }                    
                }
            }

            public void setValue(BigDecimal newval ) throws boRuntimeException
            {
                setValue( newval, true );
            }

            public void setValue(BigDecimal newval, boolean recalc) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(HandlerLIN.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    BigDecimal chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
                            if(canAlter(recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL))
                            {
    	                        _setValue(newval);
                                setInputType( recalc?AttributeHandler.INPUT_FROM_USER:AttributeHandler.INPUT_FROM_INTERNAL );
	                    	                        
                                if( recalc && getParent().onChangeSubmit("LIN"))
                                {
                                    Hashtable table = new Hashtable();
                                    getParent().setCalculated(table, "LIN");
                                    getParent().calculateFormula(table, "LIN");
                                }
	                        
                                //vou verificar se o objecto se encontra numa bridge
                                if ( getParent().p_parentBridgeRow != null )
                                {
                                    getParent().getParentBridgeRow().getBridge().lineChanged("LIN");
                                }

                                fireAfterChangeEvent( this, chgval, newval);
                            }
                    }
                }
            }

            private void setValue(BigDecimal newval, Hashtable table) throws boRuntimeException 
            {
                if (getParent().isCheckSecurity() && !this.hasRights())
                    	throw new boRuntimeException(HandlerLIN.class.getName() +
	        	".setValue()", "BO-3230", null, "");                      	                   	                                   	
                if(!ClassUtils.compare(newval,this.getValue())) {
                    BigDecimal chgval = this.getValue();

                    if ( fireBeforeChangeEvent( this, chgval, newval) )
                    {
											  if(canAlter(AttributeHandler.INPUT_FROM_INTERNAL))
												{
	                        _setValue(newval);
	                        setInputType( AttributeHandler.INPUT_FROM_INTERNAL );
	                        if( getParent().onChangeSubmit("LIN"))
	                        {
	                            getParent().setCalculated(table, "LIN");
	                            getParent().calculateFormula(table, "LIN");
	                        }

							//vou verificar se o objecto se encontra numa bridge
							if ( getParent().p_parentBridgeRow != null )
							{
								getParent().getParentBridgeRow().getBridge().lineChanged("LIN");
							}
	
                            fireAfterChangeEvent( this, chgval, newval);
	                    }
	                }
							}
            }

            public void _setValue(BigDecimal newval) throws boRuntimeException {
                if(isdbbinding) {

                        p_bridgerow.getDataRow().updateBigDecimal("LIN",newval);
                        getParent().setChanged(true);
                        super.setValid();

                } else {
                    fieldvalue = newval;
                }
            }
            public void setValueString(String value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }

            //@IF SIMPLEDATATYPE
            public double getValueDouble() throws boRuntimeException {
                return boConvertUtils.convertTodouble(this.getValue(),this);
            }
            public void setValue(double value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }
            public void setValuedouble(double value)  throws boRuntimeException 
            {
                this.setValue(boConvertUtils.convertToBigDecimal(value,this));
            }
            //@ENDIF SIMPLEDATATYPE

            
            
public  boolean haveDefaultValue() {
return false;
}
public  String formula() throws boRuntimeException {
return null;
}



            
        }
        
    } 
    
    

   

   
    public final class Handlerstate extends boObjectStateHandler {
       
        public final String STATE_Inactive="0";
        
        public final String STATE_active="1";
        
        public Handlerstate(boObject bobj) {
            super(bobj,bobj.getBoDefinition().getBoClsState().getChildStateAttributes("state"));
        }
    }

    
        
    
public  String[] getDependences(String attributeName) {
return null;
}
public  String[] addDefaultDependencesFields() {
return null;
}
public  void calculateFormula(Hashtable table, String from) throws boRuntimeException {
if ((p_mode != MODE_EDIT_TEMPLATE)) 
{
callObjBridgeCalculate(from);
if ((from != null)) 
{
}
}
}
	
	
    
    
}
