package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.core.front.validation.AbstractForm;
import kz.maks.realestate.front.columns.KvartiraSaleHistoryColumn;
import kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

import javax.swing.*;

import java.awt.*;

import static com.google.common.collect.Lists.newArrayList;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static kz.maks.core.front.FrontUtils.setForcedWidth;
import static kz.maks.core.shared.Utils.DATE_FORMAT_FULL;
import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.realestate.front.UserUtils.connected;
import static kz.maks.realestate.front.forms.kvartira.KvartiraSaleFormField.*;

public class KvartiraSaleForm extends AbstractForm<KvartiraSaleDto> {
    private static final int COL_1_1_WIDTH = 360;
    private static final int COL_1_2_WIDTH = 270;

    private static final int COL_3_1_WIDTH = 300;
    private static final int COL_3_2_WIDTH = 330;

    private static final int COL_GAP_SIZE = 10;
    private static final int FIELD_ROW_HEIGHT = 22;
    private static final int SHORT_FIELD_WIDTH = 50;

    private static final int LABEL_WIDTH_2 = 70;
    private static final int LABEL_WIDTH_3 = 120;

    public final JTabbedPane tabs = new JTabbedPane();
    public final JScrollPane historyPanel = new JScrollPane();
    public final Table<KvartiraSaleDto> table = new Table<>(KvartiraSaleHistoryColumn.values());

    public KvartiraSaleForm(Frame containerFrame) {
        super(containerFrame, KvartiraSaleFormField.values());
        tabs.setBorder(BorderFactory.createEmptyBorder());
        tabs.addTab("Квартира", buildForm());
        tabs.addTab("История изменений", buildHistoryPanel());
        ui.add(tabs);
        processAnnotations();
    }

    private Component buildHistoryPanel() {
        table.ui.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        historyPanel.setViewportView(table.ui);
        historyPanel.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        return historyPanel;
    }

    private Component buildForm() {
        JPanel formPanel = new JPanel();
        FrontUtils.addMargins(formPanel);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        {
            fieldValues.put(id, new HiddenField(id));
            fieldValues.put(modifiedById, new HiddenField(modifiedById) {
                @Override
                public Object get() {
                    return extractId(connected());
                }
            });
        }
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addKolichestvoKomnat_etazh(vBox);
                addPloshad(vBox);
                addGodPostroiki_tipStroyeniya(vBox);
                addVZaloge(vBox);
                addCena(vBox);
                addCenaProdazhi(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setMaxWidth(vBox, COL_1_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addRegion(vBox);
                addUlica(vBox);
                addPeresechenie(vBox);
                addDomKvaritra(vBox);
                addTelNumbers(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                FrontUtils.setMaxWidth(vBox, COL_1_2_WIDTH);
            }
            formPanel.add(hBox);
        }
        formPanel.add(FrontUtils.vGap(10));
        formPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        formPanel.add(FrontUtils.vGap(10));
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addOpisanie(vBox);
                addPrimechanie(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_1_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addSostoyanie(vBox);
                addPlanirovka(vBox);
                addTelefon(vBox);
                addSanuzel(vBox);
                addBalkon(vBox);
                addDver(vBox);
                addPol(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_1_2_WIDTH);
            }
            formPanel.add(hBox);
        }
        formPanel.add(FrontUtils.vGap(10));
        formPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        formPanel.add(FrontUtils.vGap(10));
        {
            Box hBox = Box.createHorizontalBox();
            {
                Box vBox = Box.createVerticalBox();
                addVArhive(vBox);
                addDataSozdaniya(vBox);
                addDataIzmeneniya(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_3_1_WIDTH);
            }
            hBox.add(FrontUtils.hGap(COL_GAP_SIZE));
            {
                Box vBox = Box.createVerticalBox();
                addRealtor(vBox);
                addIstochnikInformacii(vBox);
                vBox.add(Box.createVerticalGlue());
                hBox.add(vBox);
                setForcedWidth(vBox, COL_3_2_WIDTH);
            }
            formPanel.add(hBox);
        }
        return formPanel;
    }

    private void addVZaloge(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(isZalog.getTitle());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            CheckBox checkBox = new CheckBox(KvartiraSaleFormField.isZalog);
            fieldValues.put(KvartiraSaleFormField.isZalog, checkBox);
            fieldRow.add(checkBox.ui);
        }
        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addGodPostroiki_tipStroyeniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = new JLabel(godPostroyki.getTitle());
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent fieldComponent = addField(godPostroyki);
            FrontUtils.setMinWidth(fieldComponent, SHORT_FIELD_WIDTH);
            FrontUtils.setPreferredWidth(fieldComponent, SHORT_FIELD_WIDTH);
            fieldRow.add(fieldComponent);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JLabel label = getLabel(tipStroyeniyaId);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(tipStroyeniyaId));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRealtor(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(assignedToId);
            setForcedWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
            
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(assignedToId));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataIzmeneniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(updatedAt);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner dateSpinner = new DateSpinner(KvartiraSaleFormField.updatedAt, DATE_FORMAT_FULL);
            fieldValues.put(KvartiraSaleFormField.updatedAt, dateSpinner);
            fieldComponents.put(updatedAt, dateSpinner.ui);
            fieldRow.add(dateSpinner.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDataSozdaniya(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(createdAt);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            DateSpinner dateSpinner = new DateSpinner(KvartiraSaleFormField.createdAt, DATE_FORMAT_FULL);
            fieldValues.put(KvartiraSaleFormField.createdAt, dateSpinner);
            fieldComponents.put(createdAt, dateSpinner.ui);
            fieldRow.add(dateSpinner.ui);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addVArhive(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(isArchive);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);

            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(isArchive));
        }
        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPlanirovka(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(planirovkaId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);

            fieldRow.add(FrontUtils.hGap());
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(planirovkaId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelNumbers(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();

        fieldRow.add(addField(telNumbers));

//        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPol(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(polId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(polId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDver(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(dverId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(dverId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addBalkon(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(balkonId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(balkonId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSanuzel(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(sanuzelId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(sanuzelId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addTelefon(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(telefonId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(telefonId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPrimechanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(primechanie);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(primechanie));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addIstochnikInformacii(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(istochnikInfoId);
            setForcedWidth(label, LABEL_WIDTH_3);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(istochnikInfoId));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addSostoyanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(sostoyaniyeId);
            setForcedWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
//            FrontUtils.setForcedWidth(comboBox.ui, FIELD_WIDTH);
            fieldRow.add(addField(sostoyaniyeId));
        }
//        fieldRow.add(Box.createHorizontalGlue());
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addOpisanie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(raznoe);
            FrontUtils.setPreferredWidth(label, LABEL_WIDTH_2);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(addField(raznoe));
        }
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addDomKvaritra(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(dom);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent fieldComponent = addField(dom);
            setForcedWidth(fieldComponent, SHORT_FIELD_WIDTH);
            fieldRow.add(fieldComponent);
        }
        fieldRow.add(Box.createHorizontalGlue());
        {
            JLabel label = getLabel(kvartira);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent fieldComponent = addField(kvartira);
            setForcedWidth(fieldComponent, SHORT_FIELD_WIDTH);
            fieldRow.add(fieldComponent);
        }
        fieldRow.add(Box.createHorizontalGlue());

        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addCenaProdazhi(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            JLabel label = getLabel(cenaProdazhi);
            fieldRow.add(label);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent fieldComponent = addField(cenaProdazhi);
            FrontUtils.setPreferredWidth(fieldComponent, 100);
            fieldRow.add(fieldComponent);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addCena(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(cena));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(cena);
            FrontUtils.setPreferredWidth(component, 100);
            fieldRow.add(component);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(getLabel(valyutaId));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent fieldComponent = addField(valyutaId);
            setForcedWidth(fieldComponent, SHORT_FIELD_WIDTH);
            fieldRow.add(fieldComponent);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPeresechenie(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(peresechenie));
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(peresechenie));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addUlica(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(ulica));
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(ulica));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addRegion(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(regionId));
            fieldRow.add(FrontUtils.hGap());
            fieldRow.add(addField(regionId));
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addPloshad(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(ploshadObshaya));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(ploshadObshaya);
            fieldRow.add(component);
            FrontUtils.setPreferredWidth(component, SHORT_FIELD_WIDTH);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(getLabel(ploshadZhilaya));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(ploshadZhilaya);
            fieldRow.add(component);
            FrontUtils.setPreferredWidth(component, SHORT_FIELD_WIDTH);
        }
        fieldRow.add(FrontUtils.hGap());
        {
            fieldRow.add(getLabel(ploshadKuhnya));
        }
        fieldRow.add(FrontUtils.hGap());
        {
            JComponent component = addField(ploshadKuhnya);
            fieldRow.add(component);
            FrontUtils.setPreferredWidth(component, SHORT_FIELD_WIDTH);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    private void addKolichestvoKomnat_etazh(Box vBox) {
        Box fieldRow = Box.createHorizontalBox();
        {
            fieldRow.add(getLabel(kolichestvoKomnat));
            fieldRow.add(FrontUtils.hGap());
            JComponent kolichestvoKomnat = addField(KvartiraSaleFormField.kolichestvoKomnat);
            setForcedWidth(kolichestvoKomnat, SHORT_FIELD_WIDTH);
            fieldRow.add(kolichestvoKomnat);
            fieldRow.add(FrontUtils.hGap());

            fieldRow.add(getLabel(etazh));
            fieldRow.add(FrontUtils.hGap());
            JComponent etazh = addField(KvartiraSaleFormField.etazh);
            setForcedWidth(etazh, SHORT_FIELD_WIDTH);
            fieldRow.add(etazh);
            fieldRow.add(FrontUtils.hGap());

            fieldRow.add(getLabel(etazhnost));
            fieldRow.add(FrontUtils.hGap());
            JComponent etazhnost = addField(KvartiraSaleFormField.etazhnost);
            setForcedWidth(etazhnost, SHORT_FIELD_WIDTH);
            fieldRow.add(etazhnost);
        }
        setFieldHeight(fieldRow);
        vBox.add(fieldRow);
        addFieldRowGap(vBox);
    }

    public void setFieldHeight(Box fieldRow) {
        FrontUtils.setHeight(fieldRow, FIELD_ROW_HEIGHT);
        FrontUtils.setPreferredHeight(fieldRow, FIELD_ROW_HEIGHT);
        FrontUtils.setMaxHeight(fieldRow, FIELD_ROW_HEIGHT);
    }

    public void addFieldRowGap(Box fieldRow) {
        fieldRow.add(FrontUtils.vGap());
    }
}
